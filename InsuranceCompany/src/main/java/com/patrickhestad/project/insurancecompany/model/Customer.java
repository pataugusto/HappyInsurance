package com.patrickhestad.project.insurancecompany.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;


@Entity
@Table(name = "customer")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "national_id")
	private String nationalId;

	@JoinColumn(name = "insurance_id", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Insurance insurance;

	public Customer() {
	}

	public Customer(String firstname, String lastname, String nationalId) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.nationalId = nationalId;
	}

	public Customer(String firstname, String lastname, String nationalId, Insurance insurance) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.nationalId = nationalId;
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", nationalId='" + nationalId + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}


	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
}

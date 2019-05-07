package com.patrickhestad.project.insurancecompany.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "insurance")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Insurance implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "insurance_status")
	private String insuranceStatus;


	@OneToOne(mappedBy = "insurance")
	private Customer customer;

	public Insurance() {
	}

	public Insurance(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public Insurance(String insuranceStatus, Customer customer) {
		this.insuranceStatus = insuranceStatus;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Insurance{" +
				"id=" + id +
				", insuranceStatus='" + insuranceStatus + '\'' +
				", customer=" + customer +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}

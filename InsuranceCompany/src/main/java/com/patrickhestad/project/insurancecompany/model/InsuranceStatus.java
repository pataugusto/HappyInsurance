package com.patrickhestad.project.insurancecompany.model;

import javax.persistence.*;

@Entity
@Table(name = "insurance_status")
public class InsuranceStatus {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "insurance_status")
	private Long insuranceStatus;

	@Column(name = "description")
	private String description;

//	@OneToOne(mappedBy = "insuranceStatus")
	//private Insurance insurance;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(Long insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

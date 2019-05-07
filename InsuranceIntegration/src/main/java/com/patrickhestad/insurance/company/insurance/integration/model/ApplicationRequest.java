package com.patrickhestad.insurance.company.insurance.integration.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.patrickhestad.insurance.company.insurance.integration.validator.NameConstraint;
import com.patrickhestad.insurance.company.insurance.integration.validator.NationalIdConstraint;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="nationalId")
public class ApplicationRequest {
	@Id
	@NationalIdConstraint
	private String nationalId;

	@NameConstraint
	private String firstname;

	@NameConstraint
	private String lastname;

	private String customerId;

	private String insuranceId;

	private String insuranceStatus;


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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}
}

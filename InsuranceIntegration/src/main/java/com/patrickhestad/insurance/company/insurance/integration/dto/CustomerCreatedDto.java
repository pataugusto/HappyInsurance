package com.patrickhestad.insurance.company.insurance.integration.dto;

import java.io.Serializable;

public class CustomerCreatedDto implements Serializable {

	private String customerId;
	private String insuranceStatus;

	public CustomerCreatedDto(String customerId, String insuranceStatus) {
		this.customerId = customerId;
		this.insuranceStatus = insuranceStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}
}

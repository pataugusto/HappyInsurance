package com.patrickhestad.project.insurancecompany.repository;

import com.patrickhestad.project.insurancecompany.model.InsuranceStatus;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceStatusRepository extends CrudRepository<InsuranceStatus, Long> {
}

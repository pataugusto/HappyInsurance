package com.patrickhestad.project.insurancecompany.repository;

import com.patrickhestad.project.insurancecompany.model.Insurance;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
	Insurance findInsuranceById(Long id);
}

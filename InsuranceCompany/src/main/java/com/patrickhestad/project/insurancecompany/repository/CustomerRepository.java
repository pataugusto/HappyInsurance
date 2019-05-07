package com.patrickhestad.project.insurancecompany.repository;

import com.patrickhestad.project.insurancecompany.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Optional<Customer> findByNationalId(String nationalId);

	List<Customer> findAll();

	Customer findCustomerById(Long customerId);






}

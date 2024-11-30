package com.vinodbahiram.bynaryAssignment.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vinodbahiram.bynaryAssignment.entity.ServiceRequest;

@Repository
public interface ServiceRequestRepo extends JpaRepository<ServiceRequest, Integer> {
	
	@Query(value = "SELECT * FROM service_request WHERE customer_id = :customerId", nativeQuery = true)
	List<ServiceRequest> findByCustomerId(@Param("customerId") Long customerId);
	
	@Query(value = "SELECT * FROM service_request where id = :id", nativeQuery = true)
	ServiceRequest findRequestById(@Param("id") int id);

}

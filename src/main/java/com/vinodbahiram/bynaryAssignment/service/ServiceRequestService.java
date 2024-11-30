package com.vinodbahiram.bynaryAssignment.service;

import java.util.List;
import com.vinodbahiram.bynaryAssignment.dto.ServiceRequestDto;
import com.vinodbahiram.bynaryAssignment.entity.ServiceRequest;

public interface ServiceRequestService {
	
	public ServiceRequest createRequest(ServiceRequestDto dto);
	
	public List<ServiceRequest> getRequestsByCustomerId(Long customerId);
	
	public ServiceRequest updateRequest(Integer id);

}

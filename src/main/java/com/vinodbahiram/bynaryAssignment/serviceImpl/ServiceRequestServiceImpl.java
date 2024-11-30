package com.vinodbahiram.bynaryAssignment.serviceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinodbahiram.bynaryAssignment.dto.ServiceRequestDto;
import com.vinodbahiram.bynaryAssignment.entity.ServiceRequest;
import com.vinodbahiram.bynaryAssignment.repository.ServiceRequestRepo;
import com.vinodbahiram.bynaryAssignment.service.ServiceRequestService;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestRepo repository;

    @Override
    public ServiceRequest createRequest(ServiceRequestDto dto) {

        if (dto.getType() == null || dto.getType().isEmpty()) {
            throw new IllegalArgumentException("Request type cannot be null or empty");
        }
        if (dto.getCustomerId() == null) {
            throw new IllegalArgumentException("Customer ID is required");
        }

        ServiceRequest request = new ServiceRequest(null);
        request.setType(dto.getType());
        request.setDescription(dto.getDescription());
        request.setStatus("PENDING");
        request.setCustomerId(dto.getCustomerId());
        request.setSubmittedAt(LocalDateTime.now());

        return repository.save(request);
    }

    @Override
    public List<ServiceRequest> getRequestsByCustomerId(Long customerId) {
        List<ServiceRequest> requests = repository.findByCustomerId(customerId);
        
        if(requests != null)
        {
        	return requests;
        }
    
        return Collections.emptyList();
    }

    @Override
    public ServiceRequest updateRequest(Integer id) {
        ServiceRequest request = repository.findRequestById(id);
        if(request != null)
        {
        	request.setStatus("RESOLVED");
            request.setResolvedAt(LocalDateTime.now());
            return repository.save(request);
        }
        return null;
        
    }
}

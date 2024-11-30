package com.vinodbahiram.bynaryAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vinodbahiram.bynaryAssignment.dto.ServiceRequestDto;
import com.vinodbahiram.bynaryAssignment.entity.ServiceRequest;
import com.vinodbahiram.bynaryAssignment.serviceImpl.ServiceRequestServiceImpl;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestServiceImpl service;

    @PostMapping("/createRequest")
    public ResponseEntity<ServiceRequest> createRequest(@RequestBody ServiceRequestDto dto)
    {
        ServiceRequest request = service.createRequest(dto);
        return new ResponseEntity<ServiceRequest>(HttpStatus.CREATED);
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<List<ServiceRequest>> getRequests(@PathVariable Long customerId) 
    {
        List<ServiceRequest> requests = service.getRequestsByCustomerId(customerId);
        return ResponseEntity.ok(requests);
    }

    @PutMapping("updateRequest/{id}")
    public ResponseEntity<ServiceRequest> updateRequest(@PathVariable Integer id) 
    {
        ServiceRequest request = service.updateRequest(id);
        return ResponseEntity.ok(request);
    }
}



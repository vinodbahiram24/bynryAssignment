package com.vinodbahiram.bynaryAssignment.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ServiceRequestDto {
	 private String type;
	 private String description;
	 private String status;
	 private Long customerId;

}

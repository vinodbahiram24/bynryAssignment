package com.vinodbahiram.bynaryAssignment.entity;

import java.time.LocalDateTime;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ServiceRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Nonnull
	private String type;
	@NonNull
	private String description;
	private String status;
	private LocalDateTime submittedAt;
	private LocalDateTime resolvedAt;
	@NonNull
	private Long customerId;
	    
}

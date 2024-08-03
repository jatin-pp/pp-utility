package com.danech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.danech.model.PropertyDetails;

public interface PropertyDetailsService {


	List<PropertyDetails> findAllByPropertyType(String propertyType);

	Optional<PropertyDetails> findById(Long id);
	
	List<PropertyDetails> findAreaByCity(String cityName);

	List<PropertyDetails> findAll(Specification<PropertyDetails> and);
	List<PropertyDetails> findAll();
}

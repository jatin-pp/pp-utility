package com.danech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.danech.model.PropertyDetails;

/**
 * JPA Repository
 * Dynamic proxy will be used to create its implementation object
 * @author dev77
 *
 */
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long>,JpaSpecificationExecutor<PropertyDetails>  {
	List<PropertyDetails> findAllByPropertyType(String propertyType);
	Optional<PropertyDetails> findById(Long id);
	List<PropertyDetails> findAreaByCity(String cityname);
}
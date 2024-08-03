package com.danech.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.danech.model.PropertyDetails;
import com.danech.repository.PropertyDetailsRepository;

/**
 * Important class for Spring security as It implements UserDetailsService(I) and override
 * loadUserByUsername method and prepare Spring Security User object from the database
 *  
 * 
 * @author dev77
 *
 */
@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {

	private static final Logger LOGGER = Logger.getLogger(PropertyDetailsServiceImpl.class.getName());
	@Autowired
	private PropertyDetailsRepository PropertyDtlRepository;


	@Override
	public List<PropertyDetails> findAllByPropertyType(String propertyType) {
		return PropertyDtlRepository.findAllByPropertyType(propertyType);
	}


	@Override
	public Optional<PropertyDetails> findById(Long id) {
		// TODO Auto-generated method stub
		return PropertyDtlRepository.findById(1L);
	}




	@Override
	public List<PropertyDetails> findAll(Specification<PropertyDetails> spec) {
		// TODO Auto-generated method stub
		return PropertyDtlRepository.findAll(spec);
	}


	@Override
	public List<PropertyDetails> findAreaByCity(String cityName) {
		// TODO Auto-generated method stub
		return PropertyDtlRepository.findAreaByCity(cityName);
	}
	@Override
	public List<PropertyDetails> findAll(){
		// TODO Auto-generated method stub
		return PropertyDtlRepository.findAll();
	}


	
}

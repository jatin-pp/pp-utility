package com.danech.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danech.model.PropertyDetails;
import com.danech.service.PropertyDetailsService;
import com.danech.util.Criteria;
import com.danech.util.Restrictions;
import com.google.gson.Gson;

/**
 * 
 * This is public Controller used to login and register the Client/Customer
 * named it as UserController
 * 
 * @author dev77
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class PropertyDetailsController {

	private static final Logger LOGGER = Logger.getLogger(PropertyDetailsController.class.getName());

	@Autowired
	private PropertyDetailsService propertyDtlService;

	@PostMapping("filterData")
	public ResponseEntity<String> filterData(@RequestBody PropertyDetails propertyDetails) {
		try {

			Criteria<PropertyDetails> criteria = new Criteria<>();
			if (propertyDetails.getCity() != null) {
				criteria.add(Restrictions.eq("city", propertyDetails.getCity(), true));
			}
			if (propertyDetails.getPropertyType() != null) {
				criteria.add(Restrictions.eq("propertyType", propertyDetails.getPropertyType(), true));
			}
			if (propertyDetails.getArea() != null) {
				criteria.add(Restrictions.eq("area", propertyDetails.getArea(), true));
			}
			
//			if (propertyDetails.getArea() != null) {
//				criteria.add(Restrictions.or(
//					    Restrictions.eq("area", propertyDetails.getArea(), true),
//					    Restrictions.eq("area", "Gota", true)
//));
//			}
//			
			
			if (propertyDetails.getName() != null) {
				criteria.add(Restrictions.like("name", propertyDetails.getName(), true));
			}
			if (propertyDetails.getSuggestedArea() != null) {
				criteria.add(Restrictions.like("suggestedArea", propertyDetails.getSuggestedArea(), true));
			}
			
			
			if (propertyDetails.getPrice() != null) {
				criteria.add(Restrictions.gt("price", propertyDetails.getPrice() - 10L, true));
			} 
			if (propertyDetails.getSq_yd() != null) {
				criteria.add(Restrictions.gt("sq_yd", propertyDetails.getSq_yd() - 30L, true));
			}
		
			List<PropertyDetails> propertyDtl = propertyDtlService.findAll(criteria);
			List<String> propertyListString = new ArrayList();
			if (!propertyDtl.isEmpty()) {
				for (PropertyDetails propertyDetails2 : propertyDtl) {
					Gson gson = new Gson();

					String json = gson.toJson(propertyDetails2);
					propertyListString.add(json);
					//System.out.println("propertyDetails2"+json.toString());
				}
				Map<String, List<String>> responseMap = new HashMap<String, List<String>>();
				responseMap.put("properties", propertyListString);
				
				return ResponseEntity.ok().body(new JSONObject(responseMap).toString());
			} else {

				return ResponseEntity.ok().body("Property Not Found ");
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went wrong please try again leter");
		}
	}

	@PostMapping("fetchArea")
	public ResponseEntity<String> getArea(@RequestBody Map<String, String> request) {
		try {
			if (!request.isEmpty()) {
				if (request.values() != null) {
					System.out.println(">>>>>>>>>>>>>>>");
					System.out.println(request);
					List<PropertyDetails> areaList = propertyDtlService.findAreaByCity(request.get("city"));
					if (!areaList.isEmpty()) {
						Set<String> areas = new TreeSet();
						for (PropertyDetails propertyDetails : areaList) {
							areas.add(propertyDetails.getArea());
						}
						Map<String, Set<String>> responseMap = new HashMap<String, Set<String>>();
						responseMap.put("areas", areas);
						
						return ResponseEntity.ok().body(new JSONObject(responseMap).toString());
						//return ResponseEntity.ok().body("area As Follow " + areas);

					} else {

						return ResponseEntity.ok().body("NO Area Found ");
					}
				}
			}
			return ResponseEntity.ok().body("NO Area Found ");

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went wrong please try again leter");
		}
	}

	@GetMapping("fetchMaster")
	public ResponseEntity<String> getAllDropDown() {
		try {
			Set<String> cities = new TreeSet();
			Set<String> projectType = new TreeSet();

			List<PropertyDetails> areaList = propertyDtlService.findAll();
			if (!areaList.isEmpty()) {

				for (PropertyDetails propertyDetails : areaList) {
					if (propertyDetails.getCity() != null && propertyDetails.getPropertyType() != null) {
						cities.add(propertyDetails.getCity());
						projectType.add(propertyDetails.getPropertyType());

					}
				}

				Map<String, Set<String>> responseMap = new HashMap<String, Set<String>>();
				responseMap.put("cities", cities);
				responseMap.put("projectType", projectType);
				return ResponseEntity.ok().body( new JSONObject(responseMap).toString());
			}

			return ResponseEntity.ok().body("");

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went wrong please try again leter");
		}
	}

}

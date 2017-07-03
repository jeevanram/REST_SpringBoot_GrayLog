package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Property;
import com.example.demo.repository.PropertyRepository;;

@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository; 

	@Override
	public Property getPropertyByLoanNumber(String loanNumber) {
		return propertyRepository.findOne(loanNumber);
	}

	@Override
	public List<Property> getAllProperties() {
		return propertyRepository.findAll();
	}

}
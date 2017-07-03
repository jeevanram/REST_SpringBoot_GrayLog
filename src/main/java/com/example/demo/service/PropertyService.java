package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Property;

public interface PropertyService {
	Property getPropertyByLoanNumber(String loanNumber);
	List<Property> getAllProperties();
}
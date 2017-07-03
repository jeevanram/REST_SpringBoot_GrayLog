package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Property;
import com.example.demo.service.PropertyService;;

@RestController
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	private final Logger log = LogManager.getLogger(this.getClass());
	
    @RequestMapping(value = "/property", method = RequestMethod.GET)
    public List<Property> getProperties() {
		return propertyService.getAllProperties();
	}

    @RequestMapping(value = "/property/{loanNumber}", method = RequestMethod.GET)
    public Property getEmployee(@PathVariable("id") String loanNumber) {
		return propertyService.getPropertyByLoanNumber(loanNumber);
	}
}

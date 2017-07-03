package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "demoproperty")
public class Property {

	@Id
	@Column(name = "loannumber")
	private String loanNumber;
	@Column(name = "street")
	@NotEmpty(message = "*Please provide street")
	@Transient
	private String street;
	@Column(name = "state")
	@NotEmpty(message = "*Please provide state")
	private String state;
	@Column(name = "city")
	@NotEmpty(message = "*Please provide city")
	private String city;
	@Column(name = "zip")
	@NotEmpty(message = "*Please provide zip")
	private String zip;

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	

}
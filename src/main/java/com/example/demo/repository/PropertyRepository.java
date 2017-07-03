package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Property;

@Repository("propertyRepository")
public interface PropertyRepository extends JpaRepository<Property, String> {
}
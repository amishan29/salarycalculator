package com.example.salarycalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.salarycalculator.entity.SalaryDetails;

public interface SalaryRepository extends JpaRepository<SalaryDetails, Double> {

}

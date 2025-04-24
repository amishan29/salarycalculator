package com.example.salarycalculator.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.salarycalculator.entity.SalaryDetails;
import com.example.salarycalculator.service.SalaryService;



@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

  
  


    @PostMapping("/calculate")
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public SalaryDetails calculateSalary(@RequestBody SalaryDetails salaryDetails) {
        // Calculate salary components based on the provided CTC
        return salaryService.calculateSalary(salaryDetails.getCtc());
    }
    @PostMapping("/save")
    public SalaryDetails saveSalary(@RequestBody SalaryDetails salaryDetails) {
        // Save the provided salary details to the database
        return salaryService.saveSalaryDetails(salaryDetails);
    }


    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public SalaryDetails getSalaryDetails(@PathVariable Double id) {
        return salaryService.getSalaryDetails(id);
    }
 

}


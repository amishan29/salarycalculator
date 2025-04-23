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
public SalaryDetails calculateAndSaveSalary(@RequestBody SalaryDetails salaryDetails) {
    // Using the existing service package's calculateSalary method
    SalaryDetails calculatedDetails = salaryService.calculateSalary(salaryDetails.getCtc());
    
    return salaryService.saveSalaryDetails(calculatedDetails);
}



    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public SalaryDetails getSalaryDetails(@PathVariable Double id) {
        return salaryService.getSalaryDetails(id);
    }
 

}


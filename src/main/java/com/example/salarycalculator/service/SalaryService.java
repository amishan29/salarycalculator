package com.example.salarycalculator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salarycalculator.entity.SalaryDetails;
import com.example.salarycalculator.repository.SalaryRepository;

@Service
public class SalaryService {
    public SalaryDetails calculateSalary(Double ctc) {
        SalaryDetails salaryDetails = new SalaryDetails();

        salaryDetails.setCtc(ctc);
        salaryDetails.setBasicPay(ctc * 0.4); //  Basic Pay = 40% of CTC
        salaryDetails.setHra(salaryDetails.getBasicPay() * 0.5); //  HRA = 50% of Basic Pay
        salaryDetails.setLta(salaryDetails.getBasicPay() * 0.15); //  LTA = 15% of Basic Pay
        salaryDetails.setDearnessAllowance((salaryDetails.getBasicPay() * 0.55));//DA= 55% of Basic Pay
        salaryDetails.setPf(0.12 * (salaryDetails.getBasicPay() + salaryDetails.getDearnessAllowance())); // 12% of basic pay + DA
       
        salaryDetails.setEsic((ctc / 12) <= 21000 ? (ctc / 12) * 0.0075 : 0); // ESIC if salary <= ₹21,000
        salaryDetails.setStBonus(salaryDetails.getBasicPay() * 0.0833); //  ST Bonus = 8.33% of Basic Pay
        salaryDetails.setSpecialAllowance(ctc - (salaryDetails.getBasicPay()
                + salaryDetails.getHra()
                + salaryDetails.getLta()
                + salaryDetails.getPf()
                + salaryDetails.getEsic()
                + salaryDetails.getDearnessAllowance()
                + salaryDetails.getStBonus()));
        salaryDetails.setIncomeTax(calculateIncomeTax(ctc)); // Income Tax based on slabs

        return salaryDetails;
    }

    private Double calculateIncomeTax(Double ctc) {
        // Income Tax calculation
        Double taxableIncome = ctc - (ctc * 0.12); // Deducting PF
        if (taxableIncome <= 500000) {
            return 0.0; //  No tax for income below ₹5,00,000
        } else if (taxableIncome <= 1000000) {
            return taxableIncome * 0.2; //  20% tax for ₹5–10 Lakhs
        } else {
            return taxableIncome * 0.3; // 30% tax above ₹10 Lakhs
        }
    }

    @Autowired
    private SalaryRepository salaryRepository;


    public SalaryDetails getSalaryDetails(Double id) {
        Optional<SalaryDetails> salaryDetails = salaryRepository.findById(id);
        if (salaryDetails.isPresent()) {
            return salaryDetails.get();
        } else {
            throw new RuntimeException("Salary details not found for ID: " + id);
        }
    }
    public SalaryDetails saveSalaryDetails(SalaryDetails salaryDetails) {
        System.out.println("Saving Salary Details: " + salaryDetails);
        return salaryRepository.save(salaryDetails);
    }
   

   

}

    





package com.example.salarycalculator.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity

public class SalaryDetails {


    public SalaryDetails(){
        
    }
    public SalaryDetails( Double ctc, Double basicPay, Double hra, Double lta, Double specialAllowance, Double stBonus, 
    Double dearnessAllowance,
     Double pf, Double esic, Double incomeTax){
        super();
        this.ctc=ctc;
        this.basicPay=basicPay;
        this.hra=hra;
        this.lta=lta;
        this.specialAllowance=specialAllowance;
        this.stBonus=stBonus;
         this.dearnessAllowance=dearnessAllowance;
        this.pf=pf;
        this.esic=esic;
        this.incomeTax=incomeTax;


     }

     public Double getCtc(){
        return ctc;
     }
     public void setCtc(Double ctc){
        this.ctc=ctc;
     }

     public Double getBasicPay(){
        return basicPay;
     }
     public void setBasicPay(Double basicPay){
        this.basicPay=basicPay;
     }

     public Double getHra(){
        return hra;
     }
     public void setHra(Double hra){
        this.hra=hra;
     }
     public Double getLta(){
        return lta;
     }
     public void setLta(Double lta){
        this.lta=lta;
     }
     public Double getDearnessAllowance(){
        return dearnessAllowance;
     }
     public void setDearnessAllowance(Double dearnessAllowance){
      this.dearnessAllowance=dearnessAllowance;
     }

     public Double getSpecialAllowance(){
        return specialAllowance;
     }
     public void setSpecialAllowance(Double specialAllowance){
        this.specialAllowance=specialAllowance;
     }
     public Double getStBonus(){
        return stBonus;
     }
     public void setStBonus(Double stBonus){
        this.stBonus=stBonus;
     }
    

     public Double getPf(){
        return pf;
     }
     public void setPf(Double pf){
        this.pf=pf;
     }

     public Double getEsic(){
        return esic;
     }
     public void setEsic(Double esic){
        this.esic=esic;
     }
     public Double getIncomeTax(){
        return incomeTax;
     }
     public void setIncomeTax(Double incomeTax){
        this.incomeTax=incomeTax;
     }

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double ctc;
    private Double basicPay;
    private Double hra;
    private Double lta;
    private Double specialAllowance;
    private Double stBonus;
   private Double dearnessAllowance;
    private Double pf;
    private Double esic;
    private Double incomeTax;

    
    

}

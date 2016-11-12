package com.lumanang.jayjay.model;

public class Payslip {

    private String name;
    private String payPeriod;
    private double grossIncome;
    private double incomeTax;
    private double netIncome;
    private double superAnnuation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    public double getSuperAnnuation() {
        return superAnnuation;
    }

    public void setSuperAnnuation(double superAnnuation) {
        this.superAnnuation = superAnnuation;
    }
}

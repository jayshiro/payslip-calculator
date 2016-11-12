package com.lumanang.jayjay.service;

import com.lumanang.jayjay.model.Payslip;

public abstract class PayslipService {
    protected abstract String getPayPeriod();
    protected abstract double getGrossIncome();
    protected abstract double getIncomeTax();
    protected abstract double getNetIncome();
    protected abstract double getSuperAnnuation();
    public abstract Payslip getPayslip();
}

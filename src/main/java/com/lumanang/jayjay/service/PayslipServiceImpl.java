package com.lumanang.jayjay.service;

import com.lumanang.jayjay.model.Employee;
import com.lumanang.jayjay.model.Payslip;

public class PayslipServiceImpl extends PayslipService {

    private Employee employee;

    public PayslipServiceImpl(Employee employee) {
        this.employee = employee;
    }

    @Override
    protected String getPayPeriod() {
        return employee.getPaymentStartDate();
    }

    @Override
    protected double getGrossIncome() {
        return 0;
    }

    @Override
    protected double getIncomeTax() {
        return 0;
    }

    @Override
    protected double getNetIncome() {
        return 0;
    }

    @Override
    protected double getSuperAnnuation() {
        return 0;
    }

    @Override
    public Payslip getPayslip() {
        return null;
    }
}

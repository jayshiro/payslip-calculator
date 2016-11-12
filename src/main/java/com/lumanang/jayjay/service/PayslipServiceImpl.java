package com.lumanang.jayjay.service;

import com.lumanang.jayjay.model.Employee;
import com.lumanang.jayjay.model.Payslip;
import com.lumanang.jayjay.model.TaxTable;

import java.util.Optional;

public class PayslipServiceImpl extends PayslipService {

    private static final int MONTHS_IN_YEAR = 12;

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
        return Math.round(employee.getAnnualSalary() / MONTHS_IN_YEAR);
    }

    @Override
    protected double getIncomeTax() {
        Optional<TaxTable> optionalTaxTable = TaxTable.findByAnnualSalary(employee.getAnnualSalary());

        if(optionalTaxTable.isPresent()) {
            TaxTable taxTable = optionalTaxTable.get();
            return Math.round((((employee.getAnnualSalary() - taxTable.getSubtrahend()) * taxTable.getMultiplier())
                    + taxTable.getAddend()) / 12);
        }
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

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

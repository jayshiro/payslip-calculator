package com.lumanang.jayjay.service;

import com.lumanang.jayjay.model.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipServiceImplTest {

    private PayslipService payslipService;

    @Before
    public void setup() {
        Employee employee = new Employee("John","Doe",70000,8,"01 September - 30 September");
        payslipService = new PayslipServiceImpl(employee);
    }

    @Test
    public void shouldReturnPayPeriodEqualsPaymentStartDate() {
        assertEquals(payslipService.getPayPeriod(), "01 September - 30 September");
    }

    @Test
    public void shouldReturnCorrectGrossIncome() {
        assertEquals(payslipService.getGrossIncome(), 5833, 0);
    }

    @Test
    public void shouldCorrectlyReturnTheIncomeTax() {
        assertEquals(payslipService.getIncomeTax(), 1191, 0);
    }

    @Test
    public void shouldReturnZeroIncomeTaxForInvalidAnuualSalary() {
        Employee employee1 = new Employee("In","Valid",1000000,10,"01 November - 30 November");
        Employee employee2 = new Employee("Jane","Jean",-1,10,"01 November - 30 November");
        payslipService.setEmployee(employee1);
        assertEquals(payslipService.getIncomeTax(),0,0);
        payslipService.setEmployee(employee2);
        assertEquals(payslipService.getIncomeTax(),0,0);
    }

    @Test
    public void shouldReturnCorrectNetIncome() {
        assertEquals(payslipService.getNetIncome(), 4642, 0);
        Employee employee1 = new Employee("Dick","Smith",100000,9,"01 December - 31 December");
        payslipService.setEmployee(employee1);
        assertEquals(payslipService.getNetIncome(), 6254, 0);
    }
}

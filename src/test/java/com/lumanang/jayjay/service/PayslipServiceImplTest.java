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
}

package com.lumanang.jayjay.service;

import com.lumanang.jayjay.exception.InvalidFileExtensionException;
import com.lumanang.jayjay.exception.InvalidRowFormatException;
import com.lumanang.jayjay.model.Employee;
import com.lumanang.jayjay.model.Payslip;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvServiceImplIntegrationTest {
    private CsvService csvService;
    private PayslipService payslipService;

    @Before
    public void setup() {
        csvService = new CsvServiceImpl();
        payslipService = new PayslipServiceImpl();
    }

    @Test
    public void shouldCorrectlyComputePayslipsOfEmployeesGivenACsv()
            throws InvalidRowFormatException, IOException, InvalidFileExtensionException {
        File file = new File(getClass().getClassLoader().getResource("employeeList1.csv").getFile());
        List<Employee> employees = csvService.readCsv(file.getAbsolutePath());

        payslipService.setEmployee(employees.get(0));
        Payslip payslip1 = payslipService.getPayslip();
        assertEquals(payslip1.getName(), "David Rudd");
        assertEquals(payslip1.getPayPeriod(), "01 March – 31 March");
        assertEquals(payslip1.getGrossIncome(), 5004, 0);
        assertEquals(payslip1.getIncomeTax(), 922, 0);
        assertEquals(payslip1.getNetIncome(), 4082, 0);
        assertEquals(payslip1.getSuperAnnuation(), 450, 0);

        payslipService.setEmployee(employees.get(1));
        Payslip payslip2 = payslipService.getPayslip();
        assertEquals(payslip2.getName(), "Ryan Chen");
        assertEquals(payslip2.getPayPeriod(), "01 March – 31 March");
        assertEquals(payslip2.getGrossIncome(), 10000, 0);
        assertEquals(payslip2.getIncomeTax(), 2696, 0);
        assertEquals(payslip2.getNetIncome(), 7304, 0);
        assertEquals(payslip2.getSuperAnnuation(), 1000, 0);
    }
}

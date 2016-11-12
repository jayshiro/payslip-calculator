package com.lumanang.jayjay.service;

import com.lumanang.jayjay.exception.InvalidFileExtensionException;
import com.lumanang.jayjay.exception.InvalidRowFormatException;
import com.lumanang.jayjay.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CsvServiceImplTest {
    private CsvService csvService;

    @Before
    public void setup() {
        csvService = new CsvServiceImpl();
    }

    @Test
    public void shouldCorrectlyAccessCsvFile()
            throws InvalidRowFormatException, IOException, InvalidFileExtensionException {
        File file = new File(getClass().getClassLoader().getResource("employeeList1.csv").getFile());
        csvService.readCsv(file.getAbsolutePath());
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionIfCsvFileIsNotExisting()
            throws InvalidRowFormatException, IOException, InvalidFileExtensionException {
        csvService.readCsv("invalidFile.csv");
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void shouldThrowExceptionIfFileHasInvalidExtension()
            throws InvalidRowFormatException, IOException, InvalidFileExtensionException {
        csvService.readCsv("file.cxv");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfRowHasIncorrectLength() throws InvalidRowFormatException {
        csvService.readRow("Jack,Ryan");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfAnnualSalaryHasInvalidNumber() throws InvalidRowFormatException {
        csvService.readRow("Jack,Ryan,70000a,9,01 January - 31 January");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfSuperRateHasInvalidNumber() throws InvalidRowFormatException {
        csvService.readRow("Jack,Ryan,70000,b,01 January - 31 January");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfAnnualSalaryIsOutsideValidRange() throws InvalidRowFormatException {
        csvService.readRow("Meg,Ryan,-1,9,01 January - 31 January");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfSuperRateIsOutsideValidRange() throws InvalidRowFormatException {
        csvService.readRow("Cameron,Ryan,90000,51,01 January - 31 January");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionWhenABlankValueIsPresent() throws InvalidRowFormatException {
        csvService.readRow("T,Hanks,100000,49,");
    }

    @Test
    public void shouldProperlyExtractEmployeeRecord() throws InvalidRowFormatException {
        Employee employee = csvService.readRow("Amy,Adams,80000,10,01 January - 31 January");
        assertEquals(employee.getFirstName(), "Amy");
        assertEquals(employee.getLastName(), "Adams");
        assertEquals(employee.getAnnualSalary(), 80000, 0);
        assertEquals(employee.getSuperRate(), 10, 0);
        assertEquals(employee.getPaymentStartDate(), "01 January - 31 January");
    }
}

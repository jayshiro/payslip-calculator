package com.lumanang.jayjay.service;

import com.lumanang.jayjay.exception.InvalidFileExtensionException;
import com.lumanang.jayjay.exception.InvalidRowFormatException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
    public void shouldThrowExceptionIfSuperAnnuationHasInvalidNumber() throws InvalidRowFormatException {
        csvService.readRow("Jack,Ryan,70000,b,01 January - 31 January");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfAnnualSalaryIsOutsideValidRange() throws InvalidRowFormatException {
        csvService.readRow("Meg,Ryan,-1,9,01 January - 31 January");
    }

    @Test(expected = InvalidRowFormatException.class)
    public void shouldThrowExceptionIfSuperAnnuationIsOutsideValidRange() throws InvalidRowFormatException {
        csvService.readRow("Cameron,Ryan,90000,51,01 January - 31 January");
    }
}

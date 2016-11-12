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
}

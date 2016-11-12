package com.lumanang.jayjay.service;

import com.lumanang.jayjay.exception.InvalidFileExtensionException;
import com.lumanang.jayjay.exception.InvalidRowFormatException;
import com.lumanang.jayjay.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvServiceImpl implements CsvService {

    private static final String EXTENSION_CSV = "csv";
    private static final String DELIMITER = ",";
    private static final int ROW_LENGTH = 5;

    @Override
    public List<Employee> readCsv(String filePath)
            throws InvalidFileExtensionException, IOException, InvalidRowFormatException {
        List<Employee> employees = new ArrayList<>();

        if(hasValidFileExtension(filePath)) {
            String row = "";
            try (FileReader fileReader = new FileReader(filePath)) {

                try (BufferedReader br = new BufferedReader(fileReader)) {
                    while ((row = br.readLine()) != null) {

                        employees.add(readRow(row));
                    }
                }

            } catch (IOException e) {
                throw new IOException("File is missing. Please provide correct file path.");
            }

        } else {
            throw new InvalidFileExtensionException("Please only use CSV files.");
        }

        return employees;
    }

    @Override
    public Employee readRow(String row) throws InvalidRowFormatException {
        String[] rowData = row.split(DELIMITER);

        if(rowData.length != ROW_LENGTH) {
            throw new InvalidRowFormatException("Row must have 5 values.");
        }



        return null;
    }

    private boolean hasValidFileExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        if(index > 0) {
            if(filePath.substring(index + 1).equals(EXTENSION_CSV)) {
                return true;
            }
        }
        return false;
    }
}

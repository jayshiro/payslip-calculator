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

        if(!hasValidFileExtension(filePath)) {
            throw new InvalidFileExtensionException("Please only use CSV files.");
        }

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

        return employees;
    }

    @Override
    public Employee readRow(String row) throws InvalidRowFormatException {
        String[] rowData = row.split(DELIMITER);
        double annualSalary, superRate = 0;

        if(rowData.length != ROW_LENGTH) {
            throw new InvalidRowFormatException("Row must have 5 values.");
        }

        for(String data : rowData) {
            if(data.trim().length() == 0) {
                throw new InvalidRowFormatException("Blank values are invalid.");
            }
        }

        try{
            annualSalary = Double.parseDouble(rowData[2].trim());
            superRate = Double.parseDouble(rowData[3].trim());
        } catch(NumberFormatException nfe) {
            throw new InvalidRowFormatException("Annual salary/super annuation values must be valid numbers.");
        }

        if(annualSalary < 0 || annualSalary > 999999) {
            throw new InvalidRowFormatException("Annual salary can't be negative or more than 999,999.");
        }

        if(superRate < 0 || superRate > 50) {
            throw new InvalidRowFormatException("Super annuation must be within 0 - 50.");
        }

        return new Employee(rowData[0].trim(), rowData[1].trim(), annualSalary, superRate, rowData[4].trim());
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

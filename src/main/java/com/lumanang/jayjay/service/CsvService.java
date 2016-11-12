package com.lumanang.jayjay.service;

import com.lumanang.jayjay.exception.InvalidFileExtensionException;
import com.lumanang.jayjay.exception.InvalidRowFormatException;
import com.lumanang.jayjay.model.Employee;

import java.io.IOException;
import java.util.List;

public interface CsvService {
    public List<Employee> readCsv(String filePath) throws InvalidFileExtensionException, IOException, InvalidRowFormatException;
    public Employee readRow(String row) throws InvalidRowFormatException;
}

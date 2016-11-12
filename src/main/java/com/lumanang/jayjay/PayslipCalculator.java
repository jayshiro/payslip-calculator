package com.lumanang.jayjay;

import com.lumanang.jayjay.exception.InvalidFileExtensionException;
import com.lumanang.jayjay.exception.InvalidRowFormatException;
import com.lumanang.jayjay.model.Employee;
import com.lumanang.jayjay.service.CsvService;
import com.lumanang.jayjay.service.CsvServiceImpl;
import com.lumanang.jayjay.service.PayslipService;
import com.lumanang.jayjay.service.PayslipServiceImpl;

import java.io.IOException;
import java.util.List;

public class PayslipCalculator {
    public static void main(String [] args)
            throws InvalidRowFormatException, IOException, InvalidFileExtensionException {
        execute(args[0]);
    }

    private static void execute(String filePath)
            throws InvalidRowFormatException, IOException, InvalidFileExtensionException {
        CsvService csvService = new CsvServiceImpl();

        List<Employee> employees = csvService.readCsv(filePath);
        employees.stream()
                .forEach(employee -> {
                    PayslipService payslipService = new PayslipServiceImpl(employee);
                    System.out.println(payslipService.getPayslip());
                });


    }
}

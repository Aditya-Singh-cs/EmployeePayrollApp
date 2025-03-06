package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import java.util.List;

public interface EmployeePayrollService {
    List<EmployeePayroll> getAllEmployees();
    EmployeePayroll getEmployeeById(int empId);
    EmployeePayroll addEmployee(EmployeePayrollDTO empPayrollDTO);
    EmployeePayroll updateEmployee(int empId, EmployeePayrollDTO empPayrollDTO);
    void deleteEmployee(int empId);
}
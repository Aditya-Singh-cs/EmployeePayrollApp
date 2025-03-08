package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    @Autowired
   EmployeePayrollRepository repository;

    @Override
    public List<EmployeePayroll> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePayroll getEmployeeById(int empId) {
        return repository.findById(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));
    }

    @Override
    public EmployeePayroll addEmployee(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayroll newEmployee = new EmployeePayroll(
                empPayrollDTO.getName(),
                empPayrollDTO.getDepartment(),  // Added Department
                empPayrollDTO.getSalary()
        );
        return repository.save(newEmployee);
    }

    @Override
    public EmployeePayroll updateEmployee(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayroll employee = repository.findById(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        employee.setName(empPayrollDTO.getName());
        employee.setDepartment(empPayrollDTO.getDepartment());  // Added Department
        employee.setSalary(empPayrollDTO.getSalary());

        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        if (!repository.existsById(empId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found");
        }
        repository.deleteById(empId);
    }
}

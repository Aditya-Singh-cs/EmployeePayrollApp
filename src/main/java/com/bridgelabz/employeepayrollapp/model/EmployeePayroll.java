package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employee_payroll")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String department;
    private long salary;

    public EmployeePayroll() {}

    public EmployeePayroll(String name, String department, long salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

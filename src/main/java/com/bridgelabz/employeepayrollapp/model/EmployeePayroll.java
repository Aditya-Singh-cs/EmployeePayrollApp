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
    private long salary;

    // Constructors, Getters, Setters
    public EmployeePayroll() {}

    public EmployeePayroll(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

}
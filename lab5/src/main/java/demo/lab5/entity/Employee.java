package demo.lab5.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
    private String phoneNumber;
    private String address;
    private Instant hireDate;
    private Float salary;
    private String status;



}

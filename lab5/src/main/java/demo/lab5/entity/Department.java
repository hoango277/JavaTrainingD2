package demo.lab5.entity;


import jakarta.persistence.*;

@Entity
@Table(name= "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    private String departmentName;
    private String description;
}

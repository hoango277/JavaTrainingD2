package demo.lab5.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permission_id;

    private String permissionName;
    private String description;


}

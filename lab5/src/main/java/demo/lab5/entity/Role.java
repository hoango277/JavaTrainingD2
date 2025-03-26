package demo.lab5.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users;


}

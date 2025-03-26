package demo.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String username;
    private String password;
    private String email;
    private Integer role_id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


}

package demo.lab5.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    private String positionName;

}

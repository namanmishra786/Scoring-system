package com.example.Scoringsystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean finalized;

    @OneToMany(mappedBy = "game")
    private List<Score> scores;
}

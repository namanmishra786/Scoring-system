package com.example.Scoringsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Game game;

    private int runs;
    private int wickets;
    private int catches;
}

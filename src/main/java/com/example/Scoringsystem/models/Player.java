package com.example.Scoringsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    private int totalRuns;
    private int totalWickets;
    private int totalCatches;
}

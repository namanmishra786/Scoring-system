package com.example.Scoringsystem.dto;

import lombok.Data;

@Data
public class ScoreUpdateRequest {
    private Long playerId;
    private Long gameId;
    private int runs;
    private int wickets;
    private int catches;
}

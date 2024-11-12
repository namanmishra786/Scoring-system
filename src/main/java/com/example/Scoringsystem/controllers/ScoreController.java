package com.example.Scoringsystem.controllers;

import com.example.Scoringsystem.dto.ScoreUpdateRequest;
import com.example.Scoringsystem.models.Score;
import com.example.Scoringsystem.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ResponseEntity<String> updateScore(@RequestBody ScoreUpdateRequest request) {
        scoreService.updateScore(request);
        return ResponseEntity.ok("Score updated successfully");
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<List<Score>> getScoresByPlayer(@PathVariable Long playerId) {
        return ResponseEntity.ok(scoreService.getScoresByPlayer(playerId));
    }
}

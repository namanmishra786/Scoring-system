package com.example.Scoringsystem.controllers;

import com.example.Scoringsystem.models.Player;
import com.example.Scoringsystem.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/profile/{playerId}")
    public ResponseEntity<Player> getPlayerProfile(@PathVariable Long playerId) {
        return ResponseEntity.ok(playerService.getPlayerProfile(playerId));
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<Player>> getLeaderboard() {
        return ResponseEntity.ok(playerService.getLeaderboard());
    }
}

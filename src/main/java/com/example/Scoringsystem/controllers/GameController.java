package com.example.Scoringsystem.controllers;

import com.example.Scoringsystem.models.Game;
import com.example.Scoringsystem.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.createGame(game));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{gameId}/finalize")
    public ResponseEntity<String> finalizeGame(@PathVariable Long gameId) {
        gameService.finalizeGame(gameId);
        return ResponseEntity.ok("Game finalized successfully");
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }
}

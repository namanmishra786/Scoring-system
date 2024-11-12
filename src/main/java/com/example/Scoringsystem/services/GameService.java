package com.example.Scoringsystem.services;

import com.example.Scoringsystem.models.Game;
import com.example.Scoringsystem.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public void finalizeGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        game.setFinalized(true);
        gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}

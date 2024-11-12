package com.example.Scoringsystem.services;

import com.example.Scoringsystem.dto.ScoreUpdateRequest;
import com.example.Scoringsystem.models.Game;
import com.example.Scoringsystem.models.Player;
import com.example.Scoringsystem.models.Score;
import com.example.Scoringsystem.repositories.GameRepository;
import com.example.Scoringsystem.repositories.PlayerRepository;
import com.example.Scoringsystem.repositories.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public void updateScore(ScoreUpdateRequest request) {
        Player player = playerRepository.findById(request.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found"));
        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(() -> new RuntimeException("Game not found"));

        if (game.isFinalized()) {
            throw new RuntimeException("Cannot update score for a finalized game");
        }

        Score score = new Score();
        score.setPlayer(player);
        score.setGame(game);
        score.setRuns(request.getRuns());
        score.setWickets(request.getWickets());
        score.setCatches(request.getCatches());

        scoreRepository.save(score);

        player.setTotalRuns(player.getTotalRuns() + request.getRuns());
        player.setTotalWickets(player.getTotalWickets() + request.getWickets());
        player.setTotalCatches(player.getTotalCatches() + request.getCatches());
        playerRepository.save(player);
    }

    public List<Score> getScoresByPlayer(Long playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }
}

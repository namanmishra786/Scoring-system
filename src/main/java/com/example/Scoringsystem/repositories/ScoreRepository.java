package com.example.Scoringsystem.repositories;

import com.example.Scoringsystem.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByPlayerId(Long playerId);
}

package com.example.Scoringsystem.repositories;

import com.example.Scoringsystem.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> { }

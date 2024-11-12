package com.example.Scoringsystem.repositories;

import com.example.Scoringsystem.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> { }

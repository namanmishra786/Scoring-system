package com.example.Scoringsystem.services;

import com.example.Scoringsystem.models.Player;
import com.example.Scoringsystem.models.Team;
import com.example.Scoringsystem.repositories.PlayerRepository;
import com.example.Scoringsystem.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public void addPlayerToTeam(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));

        team.getPlayers().add(player);
        teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}

package com.example.Scoringsystem.services;

import com.example.Scoringsystem.models.Player;
import com.example.Scoringsystem.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerPlayer(Player player) {
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        playerRepository.save(player);
    }

    public Player getPlayerProfile(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public List<Player> getLeaderboard() {
        return playerRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Player::getTotalRuns).reversed())
                .collect(Collectors.toList());
    }
}

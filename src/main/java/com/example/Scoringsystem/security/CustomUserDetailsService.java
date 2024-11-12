package com.example.Scoringsystem.security;

import com.example.Scoringsystem.models.Player;
import com.example.Scoringsystem.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Adapting `Player` to Spring Security's `UserDetails` with empty authorities
        return new org.springframework.security.core.userdetails.User(
                player.getUsername(),
                player.getPassword(),
                Collections.emptyList()
        );
    }
}

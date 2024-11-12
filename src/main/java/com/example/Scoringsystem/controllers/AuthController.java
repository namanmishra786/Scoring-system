package com.example.Scoringsystem.controllers;

import com.example.Scoringsystem.dto.AuthRequest;
import com.example.Scoringsystem.dto.AuthResponse;
import com.example.Scoringsystem.models.Player;
import com.example.Scoringsystem.services.PlayerService;
import com.example.Scoringsystem.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PlayerService playerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Player player) {
        playerService.registerPlayer(player);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(new AuthResponse("Invalid credentials"));
        }
    }
}

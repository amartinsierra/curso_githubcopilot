package com.capgemini.micropersonas.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.micropersonas.model.AuthRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@RestController
public class AuthController {

    private String secretKey = "tu_clave_secreta_aqui_lo_suficientemente_larga";

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        // Validación básica de credenciales (ejemplo simplificado)
        if ("admin".equals(authRequest.getUsername()) && "admin".equals(authRequest.getPassword())) {
            String token = generateToken(authRequest.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
        }
    }

    private String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "ROLE_ADMIN"); // Rol de ejemplo
        
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
                .signWith(key)
                .compact();
    }
}
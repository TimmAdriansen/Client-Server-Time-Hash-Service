package com.example.timehashapi.service;

import com.example.timehashapi.component.HashGenerator;
import com.example.timehashapi.dto.HashResponseDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class HashService {

    private final HashGenerator hashGenerator;

    public HashService(HashGenerator hashGenerator) {
        this.hashGenerator = hashGenerator;
        updateHash();
    }

    public HashResponseDTO getHash() {
        //Using UTC format
        Instant currentTime = Instant.now().truncatedTo(ChronoUnit.MINUTES);
        String hash = hashGenerator.generate(currentTime.toString());

        return new HashResponseDTO(hash);
    }

    public void updateHash() {
    }
}

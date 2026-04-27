package com.example.timehashapi.service;

import com.example.timehashapi.component.HashGenerator;
import com.example.timehashapi.dto.HashResponseDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class HashService {

    private final HashGenerator hashGenerator;
    private final AtomicReference<String> currentHash = new AtomicReference<>();

    public HashService(HashGenerator hashGenerator) {
        this.hashGenerator = hashGenerator;
        updateHash();
    }

    public HashResponseDTO getHash() {
        return new HashResponseDTO(currentHash.get());
    }

    @Scheduled(fixedRate = 60_000)
    public void updateHash() {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        String hash = hashGenerator.generate(currentTime.toString());
        currentHash.set(hash);
    }
}

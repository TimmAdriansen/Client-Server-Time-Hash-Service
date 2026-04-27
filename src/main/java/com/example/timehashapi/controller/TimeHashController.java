package com.example.timehashapi.controller;

import com.example.timehashapi.dto.HashResponseDTO;
import com.example.timehashapi.service.HashService;
import com.example.timehashapi.service.RequestLoggingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TimeHashController {

    private final HashService hashService;
    private final RequestLoggingService requestLoggingService;

    public TimeHashController(HashService hashService, RequestLoggingService requestLoggingService) {
        this.hashService = hashService;
        this.requestLoggingService = requestLoggingService;
    }

    @GetMapping("/hashtime")
    public HashResponseDTO getHash(HttpServletRequest request) {
        HashResponseDTO response = hashService.getHash();

        requestLoggingService.logRequest(
                request.getRequestURI(),
                request.getRemoteAddr(),
                response.hash()
        );

        return response;
    }
}

package com.example.timehashapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RequestLoggingService {

    private static final Logger logger =
            LoggerFactory.getLogger(RequestLoggingService.class);

    public void logRequest(String endpoint, String ip, String hash) {
        logger.info(
                "time={} | endpoint={} | ip={} | hash={}",
                LocalDateTime.now(),
                endpoint,
                ip,
                hash
        );
    }
}

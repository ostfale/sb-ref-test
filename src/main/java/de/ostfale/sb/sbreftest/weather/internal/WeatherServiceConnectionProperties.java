package de.ostfale.sb.sbreftest.weather.internal;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "custom.weather")
public record WeatherServiceConnectionProperties(
        String url,
        int port,
        int maxRetries,
        Duration timeout,
        String token
) {
}

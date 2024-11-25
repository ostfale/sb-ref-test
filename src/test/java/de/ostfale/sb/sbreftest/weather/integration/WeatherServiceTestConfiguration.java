package de.ostfale.sb.sbreftest.weather.integration;

import de.ostfale.sb.sbreftest.weather.internal.WeatherServiceConnectionProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@TestConfiguration
public class WeatherServiceTestConfiguration {

    @Bean
    @Primary
    public WeatherServiceConnectionProperties properties() {
        return new WeatherServiceConnectionProperties(
                "https://internal.test-weather.com", 9092, 4, Duration.ofSeconds(16), "import_token"
        );
    }
}

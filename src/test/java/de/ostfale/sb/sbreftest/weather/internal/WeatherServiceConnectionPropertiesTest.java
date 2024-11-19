package de.ostfale.sb.sbreftest.weather.internal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Weather Service Connection Properties Test")
@Tag("UnitTest")
class WeatherServiceConnectionPropertiesTest {

    @Test
    @DisplayName("Given default values, when WeatherServiceConnectionProperties is instantiated, then values should be as expected")
    void testWeatherServiceConnectionPropertiesDefaultValues() {
        // Given
        String defaultUrl = "http://localhost";
        int defaultPort = 8080;
        int defaultMaxRetries = 3;
        Duration defaultTimeout = Duration.ofSeconds(30);
        String defaultToken = "default-token";

        // When
        WeatherServiceConnectionProperties properties = new WeatherServiceConnectionProperties(
                defaultUrl, defaultPort, defaultMaxRetries, defaultTimeout, defaultToken
        );

        // Then
        assertAll("properties",
                () -> assertEquals(defaultUrl, properties.url(), "URL should be default URL"),
                () -> assertEquals(defaultPort, properties.port(), "Port should be default port"),
                () -> assertEquals(defaultMaxRetries, properties.maxRetries(), "Max retries should be default max retries"),
                () -> assertEquals(defaultTimeout, properties.timeout(), "Timeout should be default timeout"),
                () -> assertEquals(defaultToken, properties.token(), "Token should be default token")
        );
    }
}

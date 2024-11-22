package de.ostfale.sb.sbreftest.weather.integration;

import de.ostfale.sb.sbreftest.weather.api.WeatherService;
import de.ostfale.sb.sbreftest.weather.internal.WeatherServiceConnectionProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("WeatherServicePropertiesCfgInternalBeanIT")
public class WeatherServicePropertiesCfgInternalBeanIT {

    @Autowired
    private WeatherService weatherService;

    @TestConfiguration
    static class Configuration {

        @Bean
        @Primary
        public WeatherServiceConnectionProperties properties() {
            return new WeatherServiceConnectionProperties(
                    "https://internal.weather.com", 8082, 2, Duration.ofSeconds(8), "internal_token"
            );
        }
    }

    @Test
    @DisplayName("Test Weather Properties from internal configuration")
    public void testProperties() {
        // given
        var expectedURL = "https://internal.weather.com";
        var expectedPort = 8082;
        var expectedRetries = 2;
        var expectedTimeout = Duration.ofSeconds(8);
        var expectedToken = "internal_token";

        // when
        WeatherServiceConnectionProperties properties = weatherService.getConnectionProperties();

        // then
        assertAll("Weather Properties",
                () -> assertEquals(expectedURL, properties.url()),
                () -> assertEquals(expectedPort, properties.port()),
                () -> assertEquals(expectedRetries, properties.maxRetries()),
                () -> assertEquals(expectedTimeout, properties.timeout()),
                () -> assertEquals(expectedToken, properties.token())
        );
    }
}

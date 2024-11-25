package de.ostfale.sb.sbreftest.weather.integration;

import de.ostfale.sb.sbreftest.weather.api.WeatherService;
import de.ostfale.sb.sbreftest.weather.internal.WeatherServiceConnectionProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import( WeatherServiceTestConfiguration.class)
@DisplayName("Use an imported property configuration for Integration Test")
@Tag("integrationTest")
public class WeatherServicePropertiesCfgImportBeanIT {

    @Autowired
    private WeatherService weatherService;

    @Test
    @DisplayName("Test Weather Properties from internal configuration")
    public void testProperties() {
        // given
        var expectedURL = "https://internal.test-weather.com";
        var expectedPort = 9092;
        var expectedRetries = 4;
        var expectedTimeout = Duration.ofSeconds(16);
        var expectedToken = "import_token";

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

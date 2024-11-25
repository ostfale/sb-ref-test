package de.ostfale.sb.sbreftest.weather.integration;

import de.ostfale.sb.sbreftest.weather.internal.WeatherServiceConnectionProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "/config-properties.properties")
@DisplayName("Test reading configuration properties external resource file")
@Tag("integrationTest")
public class WeatherConfigTestPropertySourceIT {

    @Autowired
    private WeatherServiceConnectionProperties properties;

    @Test
    @DisplayName("Test reading properties from external config file")
    public void testReadingPropertiesFromExternalConfigFile() {
        // given
        var expectedURL = "https://testexprop.weather.com";
        var expectedPort = 7071;
        var expectedRetries = 5;
        var expectedTimeout = Duration.ofSeconds(24);
        var expectedToken = "exPropToken";

        // then
        assertAll ("External Weather Properties",
                () -> assertEquals(expectedURL, properties.url()),
                () -> assertEquals(expectedPort, properties.port()),
                () -> assertEquals(expectedRetries, properties.maxRetries()),
                () -> assertEquals(expectedTimeout, properties.timeout()),
                () -> assertEquals(expectedToken, properties.token())
        );
    }
}

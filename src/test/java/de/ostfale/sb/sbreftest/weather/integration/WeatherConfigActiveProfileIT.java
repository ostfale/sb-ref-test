package de.ostfale.sb.sbreftest.weather.integration;

import de.ostfale.sb.sbreftest.weather.internal.WeatherServiceConnectionProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration test class to verify that the weather service connection properties are correctly
 * loaded from the external configuration file using the application-test profile.

 * This class uses the ActiveProfiles annotation to specify the "test" profile, which enables
 * reading properties defined in the application-test.properties file.

 * It verifies that the properties for the weather service, such as URL, port, max retries, timeout,
 * and token, are correctly injected and match the expected values.

 * An instance of WeatherServiceConnectionProperties is auto-wired into this class to facilitate
 * the reading of these properties.

 * The testReadingPropertiesFromExternalConfigFile method performs the assertions to ensure that
 * the properties have been loaded as expected.
 */

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Read application-test properties using ActiveProfiles annotation")
public class WeatherConfigActiveProfileIT {

    @Autowired
    private WeatherServiceConnectionProperties properties;

    @Test
    @DisplayName("Test reading properties from external config file using profile")
    public void testReadingPropertiesFromExternalConfigFile() {
        // given
        var expectedURL = "https://test.weather.com";
        var expectedPort = 8081;
        var expectedRetries = 3;
        var expectedTimeout = Duration.ofMillis(60);
        var expectedToken = "x3ddf22";

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

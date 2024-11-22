package de.ostfale.sb.sbreftest.weather.api;

import de.ostfale.sb.sbreftest.weather.internal.WeatherServiceConnectionProperties;
import org.springframework.core.env.Environment;

public interface WeatherService {

    Environment getEnvironment();

    WeatherServiceConnectionProperties getConnectionProperties();
}

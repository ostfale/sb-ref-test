package de.ostfale.sb.sbreftest.weather.internal;

import de.ostfale.sb.sbreftest.weather.api.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private final Environment environment;
    private final WeatherServiceConnectionProperties connectionProperties;


    public WeatherServiceImpl(Environment environment, WeatherServiceConnectionProperties connectionProperties) {
        log.info("WeatherServiceImpl created");
        this.environment = environment;
        this.connectionProperties = connectionProperties;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public WeatherServiceConnectionProperties getConnectionProperties() {
        return connectionProperties;
    }
}

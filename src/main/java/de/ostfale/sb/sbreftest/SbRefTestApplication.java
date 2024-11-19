package de.ostfale.sb.sbreftest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SbRefTestApplication {

    private static final Logger log = LoggerFactory.getLogger(SbRefTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SbRefTestApplication.class, args);
        log.info("Starting...");
    }

}

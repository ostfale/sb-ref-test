package de.ostfale.sb.sbreftest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class SbRefTestApplicationTests {

    @LocalServerPort
    private Long port;

    @Test
    void contextLoads() {
        System.out.println("Local Port: " + port );
    }
}

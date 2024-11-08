package de.ostfale.sb.sbreftest.api;

import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class TracerController {

    private static final Logger log = LoggerFactory.getLogger(TracerController.class);

    private final Tracer tracer;


    public TracerController(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping("/traceId")
    String getTraceId() {
        var traceId = Objects.requireNonNull(tracer.currentSpan()).context().traceId();
        log.info("TraceId: {}", traceId);
        return traceId;
    }
}

package org.pfragatina.apps.backoffice.backend.controller.health_check;

import org.pfragatina.shared.domain.DomainError;
import org.pfragatina.shared.domain.bus.command.CommandBus;
import org.pfragatina.shared.domain.bus.query.QueryBus;
import org.pfragatina.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckGetController extends ApiController {
    public HealthCheckGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/health-check")
    public HashMap<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put("application", "backoffice_backend");
        status.put("status", "ok");

        return status;
    }


    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

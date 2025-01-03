package org.pfragatina.apps.backoffice.backend.controller.inscription;

import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.application.InscriptionsPaginatedResponse;
import org.pfragatina.backoffice.inscriptions.application.searchAll.SearchInscriptionsByCriteriaQuery;
import org.pfragatina.shared.domain.DomainError;
import org.pfragatina.shared.domain.bus.command.CommandBus;
import org.pfragatina.shared.domain.bus.query.QueryBus;
import org.pfragatina.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public final class InscriptionsGetByCriteriaController extends ApiController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public InscriptionsGetByCriteriaController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @GetMapping("/inscriptions")
    public ResponseEntity<HashMap<String, Serializable>> index(@RequestParam HashMap<String, Serializable> criteria) {
        InscriptionsPaginatedResponse inscriptions = ask(new SearchInscriptionsByCriteriaQuery(
                parseFilters(criteria),
                Optional.ofNullable(criteria.get("order_by").toString()),
                Optional.ofNullable(criteria.get("order").toString()),
                Optional.of(Integer.valueOf((String) criteria.get("limit"))),
                Optional.of(Integer.valueOf((String) criteria.get("offset")))
        ));
        return inscriptions.inscriptions().isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(parseResponse(inscriptions), HttpStatus.OK);
    }

    private HashMap<String, Serializable> parseResponse(InscriptionsPaginatedResponse inscriptions) {
        HashMap<String, Serializable> response = new HashMap<>();

        List<HashMap<String, Serializable>> inscriptionsList = new ArrayList<>();
        for (InscriptionResponse inscription : inscriptions.inscriptions()) {
            HashMap<String, Serializable> inscriptionMap = new HashMap<>();
            inscriptionMap.put("id", inscription.id());
            inscriptionMap.put("name", inscription.name());
            inscriptionMap.put("price", inscription.price());
            inscriptionMap.put("memberNumber", inscription.memberNumber());
            inscriptionMap.put("isDouble", inscription.isDouble());
            inscriptionsList.add(inscriptionMap);
        }

        response.put("inscriptions", (Serializable) inscriptionsList);
        response.put("total", inscriptions.total());

        return response;
    }



    private List<HashMap<String, String>> parseFilters(HashMap<String, Serializable> params) {
        int maxParams = params.size();

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (int possibleFilterKey = 0; possibleFilterKey < maxParams; possibleFilterKey++) {
            if (params.containsKey(String.format("filters[%s][field]", possibleFilterKey))) {
                int key = possibleFilterKey;

                filters.add(
                        new HashMap<String, String>() {
                            {
                                put("field", (String) params.get(String.format("filters[%s][field]", key)));
                                put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
                                put("value", (String) params.get(String.format("filters[%s][value]", key)));
                            }
                        }
                );
            }
        }

        return filters;
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>();
    }
}

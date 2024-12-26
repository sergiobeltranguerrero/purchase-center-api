package org.pfragatina.backoffice.inscriptions.application.search_by_name;

import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.application.InscriptionsResponse;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionName;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionRepository;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.criteria.Criteria;
import org.pfragatina.shared.domain.criteria.Filters;
import org.pfragatina.shared.domain.criteria.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class InscriptionNameSearcher {
    private final InscriptionRepository repository;

    public InscriptionNameSearcher(InscriptionRepository repository) {
        this.repository = repository;
    }

    public InscriptionsResponse search(InscriptionName name) {
        // Incluye explícitamente el campo interno del Value Object
        Filters filters = Filters.fromValues(
                new ArrayList<>() {{
                    add(new HashMap<>() {{
                        put("field", "name");
                        put("operator", "=");
                        put("value", name.value());
                    }});
                }}
        );
        Criteria criteria = new Criteria(filters, Order.desc("name"), Optional.of(10), Optional.of(0));

        return new InscriptionsResponse(repository
                .matching(criteria)
                .stream()
                .map(InscriptionResponse::fromAggregate)
                .collect(Collectors.toList()));
    }
}


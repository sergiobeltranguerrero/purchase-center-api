package org.pfragatina.backoffice.inscriptions.application.searchAll;

import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.application.InscriptionsPaginatedResponse;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionRepository;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.criteria.Criteria;
import org.pfragatina.shared.domain.criteria.Filters;
import org.pfragatina.shared.domain.criteria.Order;
import org.pfragatina.shared.infrastructure.hibernate.PaginatedResult;

import java.util.List;
import java.util.Optional;

@Service
public final class InscriptionsByCriteriaSearcher {
    private final InscriptionRepository repository;

    public InscriptionsByCriteriaSearcher(InscriptionRepository repository) {
        this.repository = repository;
    }

    public InscriptionsPaginatedResponse search(Filters filters, Order order, Optional<Integer> limit,
                                                Optional<Integer> offset) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        PaginatedResult<Inscription> result = repository.matching(criteria);

        List<InscriptionResponse> inscriptionResponses = result.data()
                .stream()
                .map(InscriptionResponse::fromAggregate)
                .toList();

        return new InscriptionsPaginatedResponse(inscriptionResponses, result.total());
    }
}

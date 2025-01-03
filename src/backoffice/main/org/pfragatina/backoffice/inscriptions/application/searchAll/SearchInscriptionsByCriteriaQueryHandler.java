package org.pfragatina.backoffice.inscriptions.application.searchAll;

import org.pfragatina.backoffice.inscriptions.application.InscriptionsPaginatedResponse;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.bus.query.QueryHandler;
import org.pfragatina.shared.domain.criteria.Filters;
import org.pfragatina.shared.domain.criteria.Order;

@Service
public final class SearchInscriptionsByCriteriaQueryHandler implements QueryHandler<SearchInscriptionsByCriteriaQuery
        , InscriptionsPaginatedResponse> {

    private final InscriptionsByCriteriaSearcher searcher;

    public SearchInscriptionsByCriteriaQueryHandler(InscriptionsByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public InscriptionsPaginatedResponse handle(SearchInscriptionsByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.criteria());
        Order order = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}

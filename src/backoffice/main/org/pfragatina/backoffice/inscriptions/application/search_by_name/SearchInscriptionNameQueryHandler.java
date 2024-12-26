package org.pfragatina.backoffice.inscriptions.application.search_by_name;

import org.pfragatina.backoffice.inscriptions.application.InscriptionsResponse;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchInscriptionNameQueryHandler implements QueryHandler<SearchInscriptionNameQuery,
        InscriptionsResponse> {
    private final InscriptionNameSearcher searcher;

    public SearchInscriptionNameQueryHandler(InscriptionNameSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public InscriptionsResponse handle(SearchInscriptionNameQuery query) {
        return searcher.search(query.name());
    }
}

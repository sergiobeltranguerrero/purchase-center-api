package org.pfragatina.backoffice.inscriptions.application.find;

import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionId;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.bus.query.QueryHandler;

@Service
public final class FindInscriptionQueryHandler implements QueryHandler<FindInscriptionQuery, InscriptionResponse> {
    private final InscriptionFinder finder;

    public FindInscriptionQueryHandler(InscriptionFinder finder) {
        this.finder = finder;
    }

    @Override
    public InscriptionResponse handle(FindInscriptionQuery query) {
        return finder.find(new InscriptionId(query.id()));
    }
}

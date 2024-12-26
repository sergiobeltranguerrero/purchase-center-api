package org.pfragatina.backoffice.inscriptions.application.create;

import org.pfragatina.backoffice.inscriptions.application.InscriptionsResponse;
import org.pfragatina.backoffice.inscriptions.application.search_by_name.SearchInscriptionNameQuery;
import org.pfragatina.backoffice.inscriptions.domain.*;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.bus.event.EventBus;
import org.pfragatina.shared.domain.bus.query.QueryBus;


@Service
public final class InscriptionCreator {
    private final InscriptionRepository repository;
    private final EventBus eventBus;
    QueryBus queryBus;

    public InscriptionCreator(InscriptionRepository repository, EventBus eventBus, QueryBus queryBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void create(InscriptionId id, InscriptionName name, InscriptionMemberNumber memberNumber,
                       InscriptionIsDouble isDouble) {
        ensureInscriptionNameIsUnique(name);

        Inscription inscription = Inscription.create(id, name, memberNumber, isDouble);

        repository.save(inscription);
        eventBus.publish(inscription.pullDomainEvents());
    }

    private void ensureInscriptionNameIsUnique(InscriptionName name) {
        InscriptionsResponse response = queryBus.ask(new SearchInscriptionNameQuery(name.value()));
        if (!response.inscriptions().isEmpty()) {
            throw new InscriptionNameAlreadyExists(name.value());
        }
    }
}

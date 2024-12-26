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

    public void create(String id, String name, Integer integer, boolean isDouble) {
        ensureInscriptionNameIsUnique(name);

        InscriptionId inscriptionId = new InscriptionId(id);
        InscriptionName inscriptionName = new InscriptionName(name);
        InscriptionMemberNumber inscriptionMemberNumber = new InscriptionMemberNumber(integer);
        InscriptionIsDouble inscriptionIsDouble = new InscriptionIsDouble(isDouble);

        Inscription inscription = Inscription.create(inscriptionId, inscriptionName,
                inscriptionMemberNumber, inscriptionIsDouble);

        repository.save(inscription);
        eventBus.publish(inscription.pullDomainEvents());
    }

    private void ensureInscriptionNameIsUnique(String name) {
        InscriptionsResponse response = queryBus.ask(new SearchInscriptionNameQuery(name));
        if (!response.inscriptions().isEmpty()) {
            throw new InscriptionNameAlreadyExists(name);
        }
    }
}

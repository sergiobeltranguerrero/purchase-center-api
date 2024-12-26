package org.pfragatina.backoffice.inscriptions.application.find;

import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionId;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionNotExist;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionRepository;
import org.pfragatina.shared.domain.Service;

@Service
public final class InscriptionFinder {
    private final InscriptionRepository repository;

    public InscriptionFinder(InscriptionRepository repository) {
        this.repository = repository;
    }

    public InscriptionResponse find(InscriptionId id) {
        return repository.search(id)
                .map(InscriptionResponse::fromAggregate)
                .orElseThrow(() -> new InscriptionNotExist(id));
    }
}

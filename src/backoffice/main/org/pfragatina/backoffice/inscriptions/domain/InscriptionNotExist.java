package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.DomainError;

public final class InscriptionNotExist extends DomainError {

    public InscriptionNotExist(InscriptionId id) {
        super("inscription_not_exist", String.format("The inscription <%s> doesn't exist", id.value()));
    }
}

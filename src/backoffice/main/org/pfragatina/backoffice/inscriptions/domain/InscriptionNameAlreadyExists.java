package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.DomainError;

public final class InscriptionNameAlreadyExists extends DomainError {
    public InscriptionNameAlreadyExists(String name) {
        super("inscription_name_already_exists", String.format("The inscription name <%s> already exists", name));
    }
}

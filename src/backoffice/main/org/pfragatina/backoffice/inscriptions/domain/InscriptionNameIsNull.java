package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.DomainError;

public final class InscriptionNameIsNull extends DomainError {

    public InscriptionNameIsNull() {
        super("inscription_name_is_null", "The inscription name is null");
    }
}

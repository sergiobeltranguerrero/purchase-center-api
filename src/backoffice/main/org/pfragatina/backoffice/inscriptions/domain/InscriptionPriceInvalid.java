package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.DomainError;


public final class InscriptionPriceInvalid extends DomainError {
    public InscriptionPriceInvalid(double value) {
        super("inscription_price_invalid", String.format("The price %s is invalid.", value));
    }
}

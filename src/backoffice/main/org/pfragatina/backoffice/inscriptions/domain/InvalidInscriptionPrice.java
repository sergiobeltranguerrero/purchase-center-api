package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.DomainError;

public final class InvalidInscriptionPrice extends DomainError {
    public InvalidInscriptionPrice(double price, boolean isDouble) {
        super("invalid_inscription_price", String.format("The price %s is invalid for a %s inscription.", price,
                isDouble ? "double" : "single"));
    }
}

package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.MoneyValueObject;

public final class InscriptionPrice extends MoneyValueObject {

    public InscriptionPrice(double value) {
        super(value, "EUR");

        ensureIsValid(value);
    }

    public InscriptionPrice() {
        super(0, "EUR");
    }

    private void ensureIsValid(double value) {
        if (value != 675.0 && value != 1350.0) {
            throw new InscriptionPriceInvalid(value);
        }
    }


}

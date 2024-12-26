package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.IntegerValueObject;

public final class InscriptionMemberNumber extends IntegerValueObject {

    public InscriptionMemberNumber(Integer value) {
        super(value);
        ensureIsValid(value);
    }

    public InscriptionMemberNumber() {
        super(0);
    }

    private void ensureIsValid(Integer value) {
        if (value < 8) {
            throw new InscriptionMemberNumberTooLow(value);
        }
    }

}

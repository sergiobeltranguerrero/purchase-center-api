package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.BooleanValueObject;

public final class InscriptionIsDouble extends BooleanValueObject {
    public InscriptionIsDouble(boolean value) {
        super(value);
    }

    public InscriptionIsDouble() {
        super(false);
    }
}

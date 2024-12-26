package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionIsDouble;
import org.pfragatina.shared.domain.BooleanMother;

public final class InscriptionIsDoubleMother {

    public static InscriptionIsDouble create(boolean value) {
        return new InscriptionIsDouble(value);
    }

    public static InscriptionIsDouble random() {
        return create(BooleanMother.random());
    }

    public static InscriptionIsDouble isDouble() {
        return create(true);
    }

    public static InscriptionIsDouble isNotDouble() {
        return create(false);
    }
}

package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionId;
import org.pfragatina.shared.domain.UuidMother;

public final class InscriptionIdMother {

    public static InscriptionId create(String value) {
        return new InscriptionId(value);
    }

    public static InscriptionId random() {
        return create(UuidMother.random());
    }
}

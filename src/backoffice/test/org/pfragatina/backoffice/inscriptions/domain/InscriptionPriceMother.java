package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionIsDouble;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionPrice;

public final class InscriptionPriceMother {
    public static InscriptionPrice create(Double value) {
        return new InscriptionPrice(value);
    }

    public static InscriptionPrice random(InscriptionIsDouble isDouble) {
        return create(isDouble.value() ? 1350.0 : 675.0);
    }
}

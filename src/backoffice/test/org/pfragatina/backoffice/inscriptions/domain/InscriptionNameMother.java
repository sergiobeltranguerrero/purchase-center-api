package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionName;
import org.pfragatina.shared.domain.WordMother;

public final class InscriptionNameMother {
    public static InscriptionName create(String value) {
        return new InscriptionName(value);
    }

    public static InscriptionName random() {
        return create(WordMother.random());
    }
}

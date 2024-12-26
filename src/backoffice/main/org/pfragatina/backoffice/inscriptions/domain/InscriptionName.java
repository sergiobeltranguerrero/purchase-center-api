package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.StringValueObject;

public final class InscriptionName extends StringValueObject {
    public InscriptionName(String value) {
        super(value);
        ensureNotNull(value);
    }

    public InscriptionName() {
        super("");
    }

    private void ensureNotNull(String value) {
        if (value == null) {
            throw new InscriptionNameIsNull();
        }
    }
}

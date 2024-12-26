package org.pfragatina.backoffice.inscriptions.application.find;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionIdMother;

public final class FindInscriptionQueryMother {

    public static FindInscriptionQuery create(String id) {
        return new FindInscriptionQuery(id);
    }

    public static FindInscriptionQuery random() {
        return create(InscriptionIdMother.random().value());
    }
}

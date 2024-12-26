package org.pfragatina.backoffice.inscriptions.application;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionMother;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;

public final class InscriptionResponseMother {
    public static InscriptionResponse create(String id, String name, double price, int memberNumber, boolean isDouble) {
        return new InscriptionResponse(id, name, price, memberNumber, isDouble);
    }

    public static InscriptionResponse random() {
        Inscription inscriptionMother = InscriptionMother.random();
        return create(inscriptionMother.id().value(), inscriptionMother.name().value(),
                inscriptionMother.price().value(), inscriptionMother.memberNumber().value(),
                inscriptionMother.isDouble().value());
    }

    public static InscriptionResponse fromInscription(Inscription inscription) {
        return create(inscription.id().value(), inscription.name().value(),
                inscription.price().value(), inscription.memberNumber().value(),
                inscription.isDouble().value());
    }
}

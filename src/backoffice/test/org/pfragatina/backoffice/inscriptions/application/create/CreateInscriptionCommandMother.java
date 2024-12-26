package org.pfragatina.backoffice.inscriptions.application.create;

import org.pfragatina.backoffice.inscriptions.domain.*;

public final class CreateInscriptionCommandMother {

    public static CreateInscriptionCommand create(String id, String name, Integer memberNumber, Boolean isDouble) {
        return new CreateInscriptionCommand(id, name, memberNumber, isDouble);
    }

    public static CreateInscriptionCommand random() {
        return create(InscriptionIdMother.random().value(), InscriptionNameMother.random().value(),
                InscriptionMemberNumberMother.random().value(), InscriptionIsDoubleMother.random().value());
    }

}

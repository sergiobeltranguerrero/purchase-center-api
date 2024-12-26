package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.backoffice.inscriptions.application.create.CreateInscriptionCommand;

public final class InscriptionMother {
    public static Inscription create(InscriptionId id, InscriptionName name, InscriptionMemberNumber memberNumber,
                                     InscriptionIsDouble isDouble) {
        InscriptionPrice price = InscriptionPriceCalculator.calculate(isDouble);
        return new Inscription(id, name, price, memberNumber, isDouble);
    }

    public static Inscription fromRequest(CreateInscriptionCommand request) {
        return create(
                InscriptionIdMother.create(request.id()),
                InscriptionNameMother.create(request.name()),
                InscriptionMemberNumberMother.create(request.memberNumber()),
                InscriptionIsDoubleMother.create(request.isDouble())
        );
    }

    public static Inscription random() {
        return create(InscriptionIdMother.random(), InscriptionNameMother.random(),
                InscriptionMemberNumberMother.random(), InscriptionIsDoubleMother.random());
    }
}

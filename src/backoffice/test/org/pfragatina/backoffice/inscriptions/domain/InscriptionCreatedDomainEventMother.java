package org.pfragatina.backoffice.inscriptions.domain;

public final class InscriptionCreatedDomainEventMother {
    public static InscriptionCreatedDomainEvent create(String id, String name, double price, Integer memberNumber,
                                                       Boolean isDouble) {
        return new InscriptionCreatedDomainEvent(id, name, price, memberNumber, isDouble);
    }

    public static InscriptionCreatedDomainEvent fromInscription(Inscription inscription) {
        return create(inscription.id().value(), inscription.name().value(), inscription.price().value(),
                inscription.memberNumber().value(), inscription.isDouble().value());
    }

    public static InscriptionCreatedDomainEvent random() {
        InscriptionIsDouble isDouble = InscriptionIsDoubleMother.random();
        InscriptionPrice price = InscriptionPriceCalculator.calculate(isDouble);
        return create(InscriptionIdMother.random().value(), InscriptionNameMother.random().value(), price.value(),
                InscriptionMemberNumberMother.random().value(), isDouble.value());
    }
}

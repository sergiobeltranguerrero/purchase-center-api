package org.pfragatina.backoffice.inscriptions.domain;

public final class InscriptionPriceCalculator {
    public static InscriptionPrice calculate(InscriptionIsDouble isDouble) {
        return isDouble.value() ? new InscriptionPrice(1350) : new InscriptionPrice(675);
    }
}

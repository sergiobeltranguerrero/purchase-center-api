package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionMemberNumber;
import org.pfragatina.shared.domain.BoundedIntegerMother;

public final class InscriptionMemberNumberMother {

    public static InscriptionMemberNumber create(Integer value) {
        return new InscriptionMemberNumber(value);
    }

    public static InscriptionMemberNumber random() {
        return create(BoundedIntegerMother.randomWithMin(8));
    }


}

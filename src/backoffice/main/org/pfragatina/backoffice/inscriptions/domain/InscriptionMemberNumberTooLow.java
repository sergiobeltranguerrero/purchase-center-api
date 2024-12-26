package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.DomainError;

public final class InscriptionMemberNumberTooLow extends DomainError {

    public InscriptionMemberNumberTooLow(Integer value) {
        super("inscription_member_number_too_low", String.format("The inscription member number <%s> is too low", value));
    }
}

package org.pfragatina.backoffice.inscriptions.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class InscriptionMemberNumberTest {

    @Test
    @DisplayName("Create a valid member number")
    void createMemberNumber() {
        InscriptionMemberNumberMother.random();
    }

    @Test
    @DisplayName("Create an invalid member number")
    void createInvalidMemberNumber() {
        assertThrows(InscriptionMemberNumberTooLow.class, () -> InscriptionMemberNumberMother.create(0));
    }
}

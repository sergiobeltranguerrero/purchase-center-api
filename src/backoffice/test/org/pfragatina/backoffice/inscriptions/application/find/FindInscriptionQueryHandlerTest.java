package org.pfragatina.backoffice.inscriptions.application.find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.backoffice.inscriptions.InscriptionsModuleUnitTestCase;
import org.pfragatina.backoffice.inscriptions.application.InscriptionResponseMother;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionMother;
import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionNotExist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class FindInscriptionQueryHandlerTest extends InscriptionsModuleUnitTestCase {
    private FindInscriptionQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FindInscriptionQueryHandler(new InscriptionFinder(repository));
    }

    @Test
    @DisplayName("Find an inscription")
    void find_an_inscription() {
        Inscription inscription = InscriptionMother.random();
        FindInscriptionQuery query = FindInscriptionQueryMother.create(inscription.id().value());
        InscriptionResponse response = InscriptionResponseMother.fromInscription(inscription);

        shouldSearch(inscription);

        assertEquals(response, handler.handle(query));
    }

    @Test
    @DisplayName("Find an inscription that does not exist")
    void find_an_inscription_that_does_not_exist() {
        Inscription inscription = InscriptionMother.random();
        FindInscriptionQuery query = FindInscriptionQueryMother.create(inscription.id().value());

        shouldSearch();

        assertThrows(InscriptionNotExist.class, () -> handler.handle(query));
    }
}

package org.pfragatina.backoffice.inscriptions.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.backoffice.inscriptions.InscriptionsModuleUnitTestCase;
import org.pfragatina.backoffice.inscriptions.domain.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class CreateInscriptionCommandHandlerMotherTest extends InscriptionsModuleUnitTestCase {
    private CreateInscriptionCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateInscriptionCommandHandler(new InscriptionCreator(repository, eventBus, queryBus));
    }

    @Test
    @DisplayName("Create a valid inscription")
    public void create_a_valid_inscription() {
        CreateInscriptionCommand command = CreateInscriptionCommandMother.random();

        Inscription inscription = InscriptionMother.fromRequest(command);
        InscriptionCreatedDomainEvent domainEvent = InscriptionCreatedDomainEventMother.fromInscription(inscription);

        shouldSearchByName(inscription.name());

        handler.handle(command);

        shouldHaveSaved(inscription);
        shouldHavePublished(domainEvent);

    }

    @Test
    @DisplayName("Create an inscription with an existing name")
    public void create_an_inscription_with_an_existing_name() {
        CreateInscriptionCommand command = CreateInscriptionCommandMother.random();
        Inscription inscription = InscriptionMother.fromRequest(command);

        shouldSearchByName(inscription.name(), inscription);

        assertThrows(InscriptionNameAlreadyExists.class, () -> handler.handle(command));
    }
}

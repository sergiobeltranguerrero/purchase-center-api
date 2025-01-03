package org.pfragatina.backoffice.inscriptions.application.search_by_name;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.backoffice.inscriptions.InscriptionsModuleUnitTestCase;
import org.pfragatina.backoffice.inscriptions.application.InscriptionResponseMother;
import org.pfragatina.backoffice.inscriptions.application.InscriptionsResponse;
import org.pfragatina.backoffice.inscriptions.application.InscriptionsResponseMother;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionMother;
import org.pfragatina.shared.infrastructure.hibernate.PaginatedResult;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SearchInscriptionNameQueryHandlerTest extends InscriptionsModuleUnitTestCase {

    private SearchInscriptionNameQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new SearchInscriptionNameQueryHandler(new InscriptionNameSearcher(repository));
    }

    @Test
    @DisplayName("Search inscription by name")
    void search_inscription_by_name() {
        Inscription inscription = InscriptionMother.random();
        InscriptionsResponse response =
                InscriptionsResponseMother.create(Collections.singletonList(InscriptionResponseMother.fromInscription(inscription)));
        SearchInscriptionNameQuery query = SearchInscriptionNameQueryMother.create(inscription.name().value());

        shouldSearchCriteria(new PaginatedResult<>(Collections.singletonList(inscription), 1L));

        InscriptionsResponse result = handler.handle(query);

        assertEquals(response, result);
    }

    @Test
    @DisplayName("Search inscription by name not found")
    void search_inscription_by_name_not_found() {
        Inscription inscription = InscriptionMother.random();
        InscriptionsResponse response = InscriptionsResponseMother.empty();
        SearchInscriptionNameQuery query = SearchInscriptionNameQueryMother.create(inscription.name().value());

        shouldSearchByName(inscription.name());

        assertEquals(response, handler.handle(query));
    }

}

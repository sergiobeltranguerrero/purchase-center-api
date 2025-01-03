package org.pfragatina.backoffice.inscriptions;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.pfragatina.backoffice.inscriptions.application.InscriptionResponseMother;
import org.pfragatina.backoffice.inscriptions.application.InscriptionsResponseMother;
import org.pfragatina.backoffice.inscriptions.application.find.FindInscriptionQuery;
import org.pfragatina.backoffice.inscriptions.application.search_by_name.SearchInscriptionNameQuery;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionId;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionName;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionRepository;
import org.pfragatina.shared.domain.criteria.Criteria;
import org.pfragatina.shared.infrastructure.UnitTestCase;
import org.pfragatina.shared.infrastructure.hibernate.PaginatedResult;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class InscriptionsModuleUnitTestCase extends UnitTestCase {
    protected InscriptionRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(InscriptionRepository.class);
    }

    public void shouldHaveSaved(Inscription inscription) {
        verify(repository, atLeastOnce()).save(inscription);
    }

    public void shouldSearch(Inscription inscription) {
        Mockito.when(repository.search(inscription.id())).thenReturn(Optional.of(inscription));
    }

    public void shouldSearch() {
        Mockito.when(repository.search(any(InscriptionId.class))).thenReturn(Optional.empty());
    }

    public void shouldSearchByName(InscriptionName name) {
        Mockito.when(queryBus.ask(new SearchInscriptionNameQuery(name.value()))).thenReturn(InscriptionsResponseMother.empty());
    }

    public void shouldSearchByName(InscriptionName name, Inscription inscription) {
        Mockito.when(queryBus.ask(new SearchInscriptionNameQuery(name.value())))
                .thenReturn(InscriptionsResponseMother.create(Collections.singletonList(InscriptionResponseMother.fromInscription(inscription))));
    }

    public void shouldSearchCriteria( PaginatedResult<Inscription> expectedInscriptions) {
        Mockito.when(repository.matching(any(Criteria.class))).thenReturn(expectedInscriptions);
    }


}

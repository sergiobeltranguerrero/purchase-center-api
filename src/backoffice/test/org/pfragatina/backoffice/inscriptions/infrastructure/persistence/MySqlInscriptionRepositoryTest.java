package org.pfragatina.backoffice.inscriptions.infrastructure.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.backoffice.inscriptions.InscriptionModuleInfrastructureTestCase;
import org.pfragatina.backoffice.inscriptions.InscriptionsModuleUnitTestCase;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionMother;
import org.pfragatina.shared.domain.criteria.Criteria;
import org.pfragatina.shared.domain.criteria.Filters;
import org.pfragatina.shared.domain.criteria.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class MySqlInscriptionRepositoryTest extends InscriptionModuleInfrastructureTestCase {

    @Test
    @DisplayName("Save an inscription")
    void save_inscription() {
        Inscription inscription = InscriptionMother.random();
        repository.save(inscription);
    }

    @Test
    @DisplayName("Search an existing inscription by id")
    void search_existing_inscription() {
        Inscription inscription = InscriptionMother.random();
        repository.save(inscription);

        assertEquals(Optional.of(inscription), repository.search(inscription.id()));
    }

    @Test
    @DisplayName("Search a non-existing inscription by id")
    void search_non_existing_inscription() {
        assertEquals(Optional.empty(), repository.search(InscriptionMother.random().id()));
    }

    @Test
    @DisplayName("Search with criteria")
    void search_with_criteria() {
        Inscription inscription = InscriptionMother.random();
        repository.save(inscription);

        Filters filters = Filters.fromValues(
                new ArrayList<>() {{
                    add(new HashMap<>() {{
                        put("field", "name");
                        put("operator", "=");
                        put("value", inscription.name().value());
                    }});
                }}
        );
        Criteria criteria = new Criteria(filters, Order.desc("name"), Optional.of(10), Optional.of(0));

        assertEquals(1, repository.matching(criteria).size());
        assertEquals(inscription, repository.matching(criteria).getFirst());

    }
}

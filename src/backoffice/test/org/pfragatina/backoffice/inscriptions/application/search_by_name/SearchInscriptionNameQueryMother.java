package org.pfragatina.backoffice.inscriptions.application.search_by_name;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionNameMother;

public final class SearchInscriptionNameQueryMother {
    public static SearchInscriptionNameQuery create(String name) {
        return new SearchInscriptionNameQuery(name);
    }

    public static SearchInscriptionNameQuery random() {
        return create(InscriptionNameMother.random().value());
    }
}

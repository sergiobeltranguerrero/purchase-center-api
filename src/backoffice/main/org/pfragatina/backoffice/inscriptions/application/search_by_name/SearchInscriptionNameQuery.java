package org.pfragatina.backoffice.inscriptions.application.search_by_name;

import org.pfragatina.shared.domain.bus.query.Query;

import java.util.Objects;

public final class SearchInscriptionNameQuery implements Query {

    private final String name;

    public SearchInscriptionNameQuery(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        SearchInscriptionNameQuery that = (SearchInscriptionNameQuery) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package org.pfragatina.backoffice.inscriptions.application.find;

import org.pfragatina.shared.domain.bus.query.Query;

public final class FindInscriptionQuery implements Query {
    private final String id;

    public FindInscriptionQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}

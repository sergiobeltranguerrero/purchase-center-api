package org.pfragatina.backoffice.inscriptions.application;

import org.pfragatina.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Objects;

public final class InscriptionsResponse implements Response {
    private final List<InscriptionResponse> inscriptions;

    public InscriptionsResponse(List<InscriptionResponse> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<InscriptionResponse> inscriptions() {
        return inscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionsResponse that = (InscriptionsResponse) o;
        return Objects.equals(inscriptions, that.inscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(inscriptions);
    }
}

package org.pfragatina.backoffice.inscriptions.application;

import org.pfragatina.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Objects;

public final class InscriptionsPaginatedResponse implements Response {
    private final List<InscriptionResponse> inscriptions;
    private final Long total;

    public InscriptionsPaginatedResponse(List<InscriptionResponse> inscriptions, Long total) {
        this.inscriptions = inscriptions;
        this.total = total;
    }

    public List<InscriptionResponse> inscriptions() {
        return inscriptions;
    }

    public Long total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionsPaginatedResponse that = (InscriptionsPaginatedResponse) o;
        return Objects.equals(inscriptions, that.inscriptions) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(inscriptions);
        result = 31 * result + Objects.hashCode(total);
        return result;
    }
}

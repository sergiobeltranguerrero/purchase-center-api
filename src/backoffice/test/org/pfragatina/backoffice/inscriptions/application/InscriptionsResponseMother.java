package org.pfragatina.backoffice.inscriptions.application;

import org.pfragatina.shared.domain.ListMother;

import java.util.List;

public final class InscriptionsResponseMother {
    public static InscriptionsResponse create(List<InscriptionResponse> inscriptions) {
        return new InscriptionsResponse(inscriptions);
    }

    public static InscriptionsResponse random() {
        return create(ListMother.random(InscriptionResponseMother::random));
    }

    public static InscriptionsResponse times(int times) {
        return create(ListMother.create(times, InscriptionResponseMother::random));
    }

    public static InscriptionsResponse empty() {
        return new InscriptionsResponse(List.of());
    }
}

package org.pfragatina.backoffice.inscriptions.application.searchAll;

import org.pfragatina.shared.domain.bus.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class SearchInscriptionsByCriteriaQuery implements Query {

    private final List<HashMap<String, String>> criteria;
    private final Optional<String> orderBy;
    private final Optional<String> orderType;
    private final Optional<Integer> limit;
    private final Optional<Integer> offset;

    public SearchInscriptionsByCriteriaQuery(List<HashMap<String, String>> criteria, Optional<String> orderBy,
                                             Optional<String> orderType, Optional<Integer> limit,
                                             Optional<Integer> offset) {
        this.criteria = criteria;
        this.orderBy = orderBy;
        this.orderType = orderType;
        this.limit = limit;
        this.offset = offset;
    }

    public List<HashMap<String, String>> criteria() {
        return criteria;
    }

    public Optional<String> orderBy() {
        return orderBy;
    }

    public Optional<String> orderType() {
        return orderType;
    }

    public Optional<Integer> limit() {
        return limit;
    }

    public Optional<Integer> offset() {
        return offset;
    }

}

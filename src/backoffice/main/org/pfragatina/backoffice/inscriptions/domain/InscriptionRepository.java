package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.criteria.Criteria;
import org.pfragatina.shared.infrastructure.hibernate.PaginatedResult;

import java.util.Optional;

public interface InscriptionRepository {

    void save(Inscription inscription);

    Optional<Inscription> search(InscriptionId id);

    PaginatedResult<Inscription> matching(Criteria criteria);

}

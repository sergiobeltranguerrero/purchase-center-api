package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepository {

    void save(Inscription inscription);

    Optional<Inscription> search(InscriptionId id);

    List<Inscription> matching(Criteria criteria);

}

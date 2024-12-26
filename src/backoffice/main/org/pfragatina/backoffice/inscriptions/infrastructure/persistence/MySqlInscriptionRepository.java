package org.pfragatina.backoffice.inscriptions.infrastructure.persistence;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionId;
import org.pfragatina.shared.domain.criteria.Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionRepository;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.infrastructure.hibernate.HibernateRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("backoffice-transaction_manager")
public class MySqlInscriptionRepository extends HibernateRepository<Inscription> implements InscriptionRepository {

    public MySqlInscriptionRepository(@Qualifier("backoffice-session_factory")SessionFactory sessionFactory) {
        super(sessionFactory, Inscription.class);
    }

    @Override
    public void save(Inscription inscription) {
        persist(inscription);
    }

    @Override
    public Optional<Inscription> search(InscriptionId id) {
        return byId(id);
    }

    @Override
    public List<Inscription> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

}

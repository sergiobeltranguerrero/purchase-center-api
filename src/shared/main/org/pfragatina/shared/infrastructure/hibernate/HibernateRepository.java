package org.pfragatina.shared.infrastructure.hibernate;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;
import org.pfragatina.shared.domain.Identifier;
import org.pfragatina.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;
    protected final HibernateCriteriaConverter<T> criteriaConverter;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
        this.criteriaConverter = new HibernateCriteriaConverter<>(sessionFactory.getCriteriaBuilder());
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected Optional<T> byId(Identifier id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected PaginatedResult<T> byCriteria(Criteria criteria) {
        CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);
        CriteriaQuery<Long> countCriteria = criteriaConverter.convertCount(criteria, aggregateClass);

        Long total = sessionFactory.getCurrentSession().createQuery(countCriteria).getSingleResult();
        var query = sessionFactory.getCurrentSession().createQuery(hibernateCriteria);

        criteria.offset().ifPresent(query::setFirstResult);
        criteria.limit().ifPresent(query::setMaxResults);

        return new PaginatedResult<>(query.getResultList(), total, criteria.limit().orElse(null),
                criteria.offset().orElse(null));
    }

    protected List<T> all() {
        CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);

        criteria.from(aggregateClass);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }
}

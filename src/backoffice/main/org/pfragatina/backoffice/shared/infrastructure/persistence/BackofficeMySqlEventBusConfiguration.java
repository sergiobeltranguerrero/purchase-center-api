package org.pfragatina.backoffice.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.pfragatina.shared.infrastructure.bus.event.DomainEventsInformation;
import org.pfragatina.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import org.pfragatina.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import org.pfragatina.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackofficeMySqlEventBusConfiguration {
    private final SessionFactory sessionFactory;
    private final DomainEventsInformation domainEventsInformation;
    private final SpringApplicationEventBus eventBus;

    public BackofficeMySqlEventBusConfiguration(
            @Qualifier("backoffice-session_factory") SessionFactory sessionFactory,
            DomainEventsInformation domainEventsInformation,
            SpringApplicationEventBus eventBus) {
        this.sessionFactory = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.eventBus = eventBus;
    }

    @Bean
    public MySqlEventBus backofficeMySqlEventBus() {
        return new MySqlEventBus(sessionFactory);
    }

    @Bean
    public MySqlDomainEventsConsumer backofficeMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, eventBus);
    }
}

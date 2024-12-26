package org.pfragatina.backoffice.shared.infrastructure.persistence.bus.event.rabbitmq;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionCreatedDomainEvent;
import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({InscriptionCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public boolean wasExecuted = false;

    public void on(InscriptionCreatedDomainEvent event) {
        wasExecuted = true;
    }
}

package org.pfragatina.backoffice.shared.infrastructure.persistence.bus.event.rabbitmq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.backoffice.BackofficeContextInfrastructureTestCase;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionCreatedDomainEvent;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionCreatedDomainEventMother;
import org.pfragatina.shared.infrastructure.bus.event.DomainEventSubscriberInformation;
import org.pfragatina.shared.infrastructure.bus.event.DomainEventSubscribersInformation;
import org.pfragatina.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import org.pfragatina.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class RabbitMqEventBusTest extends BackofficeContextInfrastructureTestCase {
    @Autowired
    private RabbitMqEventBus bus;
    @Autowired
    private RabbitMqDomainEventsConsumer consumer;
    @Autowired
    private TestAllWorksOnRabbitMqEventsPublished subscriber;

    @BeforeEach
    void setUp() {
        subscriber.wasExecuted = false;
        consumer.withSubscribersInformation(
                new DomainEventSubscribersInformation(
                        new HashMap<>() {{
                            put(TestAllWorksOnRabbitMqEventsPublished.class, new DomainEventSubscriberInformation(
                                    TestAllWorksOnRabbitMqEventsPublished.class,
                                    Collections.singletonList(InscriptionCreatedDomainEvent.class)
                            ));
                        }}
                )
        );
    }

    @Test
    @DisplayName("It should publish and consume domain events")
    void it_should_publish_and_consume_domain_events() throws Exception {
        InscriptionCreatedDomainEvent domainEvent = InscriptionCreatedDomainEventMother.random();
        bus.publish(Collections.singletonList(domainEvent));
        consumer.consume();
        eventually(() -> assertTrue(subscriber.wasExecuted));
    }
}

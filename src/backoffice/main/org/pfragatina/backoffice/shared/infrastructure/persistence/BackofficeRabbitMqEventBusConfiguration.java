package org.pfragatina.backoffice.shared.infrastructure.persistence;

import org.pfragatina.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import org.pfragatina.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import org.pfragatina.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackofficeRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus failoverPublisher;

    public BackofficeRabbitMqEventBusConfiguration(
            RabbitMqPublisher publisher,
        @Qualifier("backofficeMySqlEventBus") MySqlEventBus failoverPublisher) {
        this.publisher = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Bean
    public RabbitMqEventBus backofficeRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher, failoverPublisher);
    }
}

package org.pfragatina.apps.backoffice.backend.command;

import org.pfragatina.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import org.pfragatina.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeRabbitMqDomainEventsCommand extends ConsoleCommand {
    private final RabbitMqDomainEventsConsumer consumer;

    public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}

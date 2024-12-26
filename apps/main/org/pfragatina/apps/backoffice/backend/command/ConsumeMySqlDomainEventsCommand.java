package org.pfragatina.apps.backoffice.backend.command;

import org.pfragatina.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import org.pfragatina.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {
    private final MySqlDomainEventsConsumer consumer;

    public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}

package org.pfragatina.apps.backoffice.backend;

import java.util.HashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import org.pfragatina.apps.backoffice.backend.command.ConsumeMySqlDomainEventsCommand;
import org.pfragatina.apps.backoffice.backend.command.ConsumeRabbitMqDomainEventsCommand;
import org.pfragatina.shared.domain.Service;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
	value = { "org.pfragatina.shared", "org.pfragatina.backoffice", "org.pfragatina.apps.backoffice.backend" }
)
public class BackofficeBackendApplication {

	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
				put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
				put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
			}
		};
	}
}

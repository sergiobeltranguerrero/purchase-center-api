package org.pfragatina.apps.backoffice.backend;

import org.pfragatina.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        value = {"org.pfragatina.shared", "org.pfragatina.backoffice", "org.pfragatina.apps.backoffice.backend"}
)
public class BackofficeBackendApplication {

    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {
            {
            }
        };
    }
}

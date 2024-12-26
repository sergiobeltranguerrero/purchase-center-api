package org.pfragatina.backoffice.shared.infrastructure.persistence;

import org.pfragatina.shared.infrastructure.config.Parameter;
import org.pfragatina.shared.infrastructure.config.ParameterNotExist;
import org.pfragatina.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class BackofficeHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter parameter;
    private final String CONTEXT_NAME = "backoffice";

    public BackofficeHibernateConfiguration(HibernateConfigurationFactory factory, Parameter parameter) {
        this.factory = factory;
        this.parameter = parameter;
    }

    @Bean("backoffice-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws ParameterNotExist, IOException {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("backoffice-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws ParameterNotExist, IOException {
        return factory.sessionFactory(CONTEXT_NAME, dataSource() );
    }

    @Bean("backoffice-data_source")
    public DataSource dataSource() throws ParameterNotExist, IOException {
        return factory.dataSource(
                parameter.get("BACKOFFICE_DATABASE_HOST"),
                parameter.getInt("BACKOFFICE_DATABASE_PORT"),
                parameter.get("BACKOFFICE_DATABASE_NAME"),
                parameter.get("BACKOFFICE_DATABASE_USER"),
                parameter.get("BACKOFFICE_DATABASE_PASSWORD")
        );
    }


}

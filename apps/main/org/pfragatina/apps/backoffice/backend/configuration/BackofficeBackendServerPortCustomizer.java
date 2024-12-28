package org.pfragatina.apps.backoffice.backend.configuration;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import org.pfragatina.shared.infrastructure.config.Parameter;
import org.pfragatina.shared.infrastructure.config.ParameterNotExist;

@Component
public class BackofficeBackendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	Parameter param;

	public BackofficeBackendServerPortCustomizer(Parameter parameter) {
		this.param = parameter;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		try {
			factory.setPort(param.getInt("BACKEND_SERVER_PORT"));
		} catch (ParameterNotExist parameterNotExist) {
			parameterNotExist.printStackTrace();
		}
	}
}

package org.pfragatina.apps.backoffice.controller.health_check;

import org.junit.jupiter.api.Test;

import org.pfragatina.apps.ApplicationTestCase;

final class HealthCheckGetControllerTest extends ApplicationTestCase {

	@Test
	void check_the_app_is_working_ok() throws Exception {
		assertResponse("/health-check", 200, "{'application':'backoffice_backend','status':'ok'}");
	}
}

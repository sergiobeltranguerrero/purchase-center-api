package org.pfragatina.backoffice;

import org.pfragatina.apps.backoffice.backend.BackofficeBackendApplication;
import org.pfragatina.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = BackofficeBackendApplication.class)
@SpringBootTest
public abstract class BackofficeContextInfrastructureTestCase extends InfrastructureTestCase {
}

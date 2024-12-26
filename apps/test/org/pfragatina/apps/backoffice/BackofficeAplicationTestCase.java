package org.pfragatina.apps.backoffice;

import org.pfragatina.apps.ApplicationTestCase;
import org.springframework.transaction.annotation.Transactional;

@Transactional("backoffice-transaction_manager")
public abstract class BackofficeAplicationTestCase extends ApplicationTestCase {
}

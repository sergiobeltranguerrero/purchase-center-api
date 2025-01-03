package org.pfragatina.apps.backoffice.backend;

import org.springframework.transaction.annotation.Transactional;

import org.pfragatina.apps.ApplicationTestCase;

@Transactional("backoffice-transaction_manager")
public abstract class BackofficeBackendApplicationTestCase extends ApplicationTestCase {}

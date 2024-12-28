package org.pfragatina.apps.backoffice;

import org.springframework.transaction.annotation.Transactional;

import org.pfragatina.apps.ApplicationTestCase;

@Transactional("backoffice-transaction_manager")
public abstract class BackofficeAplicationTestCase extends ApplicationTestCase {}

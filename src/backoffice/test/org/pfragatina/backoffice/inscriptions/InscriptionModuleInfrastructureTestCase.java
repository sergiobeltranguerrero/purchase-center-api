package org.pfragatina.backoffice.inscriptions;

import org.pfragatina.backoffice.BackofficeContextInfrastructureTestCase;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class InscriptionModuleInfrastructureTestCase extends BackofficeContextInfrastructureTestCase {
    @Autowired
    protected InscriptionRepository repository;
}

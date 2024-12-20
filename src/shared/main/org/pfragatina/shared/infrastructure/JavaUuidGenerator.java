package org.pfragatina.shared.infrastructure;

import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}

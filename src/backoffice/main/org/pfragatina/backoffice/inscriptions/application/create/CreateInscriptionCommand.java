package org.pfragatina.backoffice.inscriptions.application.create;

import org.pfragatina.shared.domain.bus.command.Command;

public final class CreateInscriptionCommand implements Command {
    private final String id;
    private final String name;
    private final Integer memberNumber;
    private final Boolean isDouble;

    public CreateInscriptionCommand(String id, String name, Integer memberNumber, Boolean isDouble) {
        this.id = id;
        this.name = name;
        this.memberNumber = memberNumber;
        this.isDouble = isDouble;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }


    public Integer memberNumber() {
        return memberNumber;
    }

    public Boolean isDouble() {
        return isDouble;
    }
}

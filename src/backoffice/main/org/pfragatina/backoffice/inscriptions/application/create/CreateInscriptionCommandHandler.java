package org.pfragatina.backoffice.inscriptions.application.create;

import org.pfragatina.shared.domain.Service;
import org.pfragatina.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateInscriptionCommandHandler implements CommandHandler<CreateInscriptionCommand> {
    private final InscriptionCreator creator;

    public CreateInscriptionCommandHandler(InscriptionCreator creator) {
        this.creator = creator;
    }
    @Override
    public void handle(CreateInscriptionCommand command) {
        creator.create(command.id(), command.name(), command.memberNumber(), command.isDouble());
    }
}

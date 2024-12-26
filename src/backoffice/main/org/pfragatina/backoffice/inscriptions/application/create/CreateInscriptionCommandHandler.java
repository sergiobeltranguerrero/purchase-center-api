package org.pfragatina.backoffice.inscriptions.application.create;

import org.pfragatina.backoffice.inscriptions.domain.InscriptionId;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionIsDouble;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionMemberNumber;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionName;
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
        InscriptionId id = new InscriptionId(command.id());
        InscriptionName name = new InscriptionName(command.name());
        InscriptionIsDouble isDouble = new InscriptionIsDouble(command.isDouble());
        InscriptionMemberNumber memberNumber = new InscriptionMemberNumber(command.memberNumber());

        creator.create(id, name, memberNumber, isDouble);
    }
}

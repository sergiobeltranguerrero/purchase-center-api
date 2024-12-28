package org.pfragatina.apps.backoffice.backend.controller.inscription;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.pfragatina.backoffice.inscriptions.application.create.CreateInscriptionCommand;
import org.pfragatina.backoffice.inscriptions.domain.*;
import org.pfragatina.shared.domain.DomainError;
import org.pfragatina.shared.domain.bus.command.CommandBus;
import org.pfragatina.shared.domain.bus.query.QueryBus;
import org.pfragatina.shared.infrastructure.spring.ApiController;

@RestController
public final class InscriptionsPostController extends ApiController {

	private final QueryBus queryBus;
	private final CommandBus commandBus;

	public InscriptionsPostController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
		this.queryBus = queryBus;
		this.commandBus = commandBus;
	}

	@PostMapping("/inscriptions")
	public ResponseEntity<String> index(@RequestBody HashMap<String, String> request) {
		commandBus.dispatch(
			new CreateInscriptionCommand(
				request.get("id"),
				request.get("name"),
				Integer.parseInt(request.get("memberNumber")),
				Boolean.parseBoolean(request.get("isDouble"))
			)
		);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<>() {
			{
				put(InscriptionMemberNumberTooLow.class, HttpStatus.BAD_REQUEST);
				put(InscriptionPriceInvalid.class, HttpStatus.BAD_REQUEST);
				put(InvalidInscriptionPrice.class, HttpStatus.BAD_REQUEST);
				put(InscriptionNameAlreadyExists.class, HttpStatus.BAD_REQUEST);
				put(InscriptionNameIsNull.class, HttpStatus.BAD_REQUEST);
			}
		};
	}
}

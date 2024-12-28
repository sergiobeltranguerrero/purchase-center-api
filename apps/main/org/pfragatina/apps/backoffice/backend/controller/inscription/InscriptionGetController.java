package org.pfragatina.apps.backoffice.backend.controller.inscription;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.pfragatina.backoffice.inscriptions.application.InscriptionResponse;
import org.pfragatina.backoffice.inscriptions.application.find.FindInscriptionQuery;
import org.pfragatina.backoffice.inscriptions.domain.InscriptionNotExist;
import org.pfragatina.shared.domain.DomainError;
import org.pfragatina.shared.domain.bus.command.CommandBus;
import org.pfragatina.shared.domain.bus.query.QueryBus;
import org.pfragatina.shared.infrastructure.spring.ApiController;

@RestController
public final class InscriptionGetController extends ApiController {

	private final QueryBus queryBus;
	private final CommandBus commandBus;

	public InscriptionGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
		this.queryBus = queryBus;
		this.commandBus = commandBus;
	}

	@GetMapping("/inscriptions/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) {
		InscriptionResponse inscription = ask(new FindInscriptionQuery(id));
		return getHashMapResponseEntity(inscription);
	}

	private ResponseEntity<HashMap<String, Serializable>> getHashMapResponseEntity(InscriptionResponse inscription) {
		HashMap<String, Serializable> response = new HashMap<>();
		response.put("id", inscription.id());
		response.put("name", inscription.name());
		response.put("price", inscription.price());
		response.put("memberNumber", inscription.memberNumber());
		response.put("isDouble", inscription.isDouble());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<>() {
			{
				put(InscriptionNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}

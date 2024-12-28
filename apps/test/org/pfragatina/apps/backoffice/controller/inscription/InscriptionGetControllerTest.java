package org.pfragatina.apps.backoffice.controller.inscription;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.pfragatina.apps.backoffice.BackofficeAplicationTestCase;

public final class InscriptionGetControllerTest extends BackofficeAplicationTestCase {

	@Test
	@DisplayName("Get inscription by id")
	void get_inscription_by_id() throws Exception {
		String id = "4f639c1e-ac15-403f-a0a6-b4d7e2d3388d";
		String body =
			"{\"id\": \"" +
			id +
			"\", \"name\": \"Inscription name\", \"price\": 675, \"memberNumber\": 8, " +
			"\"isDouble\": false}";

		givenThereIsAnInscription(body);

		assertResponse("/inscriptions/" + id, 200, body);
	}

	@Test
	@DisplayName("Get inscription by id not found")
	void get_inscription_by_id_not_found() throws Exception {
		String notExistId = "d60c70cf-98a9-49b3-9996-ae0deb3c7849";

		assertResponse(
			"/inscriptions/" + notExistId,
			404,
			"{\"error_code\": \"inscription_not_exist\", \"message\": " +
			"\"The inscription <d60c70cf-98a9-49b3-9996-ae0deb3c7849> doesn't exist\"}"
		);
	}

	private void givenThereIsAnInscription(String body) throws Exception {
		assertRequestWithBody("POST", "/inscriptions", body, 201);
	}
}

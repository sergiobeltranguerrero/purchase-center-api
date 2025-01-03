package org.pfragatina.apps.backoffice.backend.controller.inscription;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.apps.backoffice.backend.BackofficeBackendApplicationTestCase;

class InscriptionsGetByCriteriaControllerTest extends BackofficeBackendApplicationTestCase {

    String inscriptionSenseEsme = "{\"id\": \"4f639c1e-ac15-403f-a0a6-b4d7e2d3388d\", \"name\": \"Sense Esme\", \"price\": 675, \"memberNumber\": 8, \"isDouble\": false}";
    String inscriptionSensePressa = "{\"id\": \"5e639c1e-ac15-403f-a0a6-b4d7e2d3388e\", \"name\": \"Sense Pressa\", \"price\": 675, \"memberNumber\": 8, \"isDouble\": false}";

    @Test
    @DisplayName("Get inscriptions by criteria via request params")
    void get_inscriptions_by_criteria_via_request_params() throws Exception {
        // Crear inscripciones en el sistema
        givenThereAreInscriptions(inscriptionSenseEsme, inscriptionSensePressa);

        // Construir los parámetros del request
        String requestParams = "filters[0][field]=name&filters[0][operator]=CONTAINS&filters[0][value]=Sense"
                + "&order_by=name&order=ASC&limit=10&offset=0";

        // Respuesta esperada
        String expectedResponse = "{"
                + "\"inscriptions\": ["
                + "  {"
                + "    \"id\": \"4f639c1e-ac15-403f-a0a6-b4d7e2d3388d\","
                + "    \"name\": \"Sense Esme\","
                + "    \"price\": 675,"
                + "    \"memberNumber\": 8,"
                + "    \"isDouble\": false"
                + "  },"
                + "  {"
                + "    \"id\": \"5e639c1e-ac15-403f-a0a6-b4d7e2d3388e\","
                + "    \"name\": \"Sense Pressa\","
                + "    \"price\": 675,"
                + "    \"memberNumber\": 8,"
                + "    \"isDouble\": false"
                + "  }"
                + "],"
                + "\"total\": 2"
                + "}";

        assertResponse("/inscriptions?" + requestParams, 200, expectedResponse);
    }

    private void givenThereAreInscriptions(String... inscriptions) throws Exception {
        for (String inscription : inscriptions) {
            assertRequestWithBody("POST", "/inscriptions", inscription, 201);
        }
    }
}

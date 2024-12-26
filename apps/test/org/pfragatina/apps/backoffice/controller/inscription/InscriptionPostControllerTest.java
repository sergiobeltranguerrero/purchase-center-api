package org.pfragatina.apps.backoffice.controller.inscription;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pfragatina.apps.backoffice.BackofficeAplicationTestCase;

public final class InscriptionPostControllerTest extends BackofficeAplicationTestCase {

    @Test
    @DisplayName("Create a valid inscription")
    void create_a_valid_inscription() throws Exception {
        assertRequestWithBody(
                "POST",
                "/inscriptions",
                "{\"id\": \"4f639c1e-ac15-403f-a0a6-b4d7e2d3388d\", \"name\": \"Inscription name\", \"price\": 675, " +
                        "\"memberNumber\": 8, \"isDouble\": false}",
                201
        );
    }

    @Test
    @DisplayName("Create an inscription without name")
    void create_an_inscription_without_name() throws Exception {
        assertRequestWithBody(
                "POST",
                "/inscriptions",
                "{\"id\": \"4f639c1e-ac15-403f-a0a6-b4d7e2d3388d\", " +
                        "\"memberNumber\": 8, \"isDouble\": false}",
                400,
                "{\"error_code\": \"inscription_name_is_null\", \"message\": \"The inscription name is null\"}"
        );
    }

    @Test
    @DisplayName("Create an inscription with invalid member number")
    void create_an_inscription_with_invalid_member_number() throws Exception {
        assertRequestWithBody(
                "POST",
                "/inscriptions",
                "{\"id\": \"4f639c1e-ac15-403f-a0a6-b4d7e2d3388d\", \"name\": \"Inscription name\", " +
                        "\"memberNumber\": 0, \"isDouble\": false}",
                400,
                "{\"error_code\": \"inscription_member_number_too_low\", \"message\": \"The inscription member number <0> is too low\"}"
        );
    }

}

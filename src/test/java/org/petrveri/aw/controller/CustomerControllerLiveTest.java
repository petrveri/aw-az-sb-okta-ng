package org.petrveri.aw.controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;

public class CustomerControllerLiveTest {
    private final static String RESOURCE_SERVER = "http://localhost:8080";

    @Test
    public void givenPersons1_whenGerPersons1_thenOkForPersonsResource() {
        final Response personResponse = RestAssured.given()    //  .header("Authorization", "Bearer " + accessToken)
            .get(RESOURCE_SERVER + "/api/customers/1");
        assertEquals(200, personResponse.getStatusCode());
        assertNotNull(personResponse.jsonPath().get("firstName"));
    }
}

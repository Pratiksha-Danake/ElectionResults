package com.amaap.electionresult.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {


    @Test
    void shouldBeAbleToReturnHashCode() {
        // arrange
        Response response = new Response(HttpStatus.OK, "CREATED");

        // act && assert
        assertNotNull(response.hashCode());
    }

    @Test
    void shouldBeAbleToAssertTheEqualityOfTwoResponseInstances() {
        // arrange
        Response response = new Response(HttpStatus.OK, "CREATED");
        Response response1 = new Response(HttpStatus.OK, "ADDED");
        Response response2 = new Response(HttpStatus.BAD_REQUEST, "Invalid Data Provided");


        // act && assert
        assertTrue(response.equals(response));
        assertFalse(response.equals(null));
        assertFalse(response.equals(new Object()));
        assertFalse(response.equals(response1));
        assertFalse(response.equals(response2));
    }
}
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

        // act && assert
        assertTrue(response.equals(response));
        assertFalse(response.equals(null));
        assertFalse(response.equals(new Object()));
        
    }
}
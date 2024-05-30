package com.amaap.electionresult.controller;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyControllerTest {
    private PartyController partyController;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        partyController = injector.getInstance(PartyController.class);
    }

    @Test
    void shouldBeAbleToReturnResponseAsOkIfCreatesPartySuccessfully() throws FileNotFoundException {
        // arrange
        Response expected = new Response(HttpStatus.OK, "CREATED");
        String partyName = "BJP";
        int voteCount = 100;

        // act
        Response actual = partyController.createParty(partyName, voteCount);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnResponseAsBadRequestIfPartyNameProvidedIsInvalid() throws FileNotFoundException {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Data Provided");
        String partyName = "";
        int voteCount = 100;

        // act
        Response actual = partyController.createParty(partyName, voteCount);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnResponseAsBadRequestIfVoteCountProvidedIsInvalid() throws FileNotFoundException {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Data Provided");
        String partyName = "BJP";
        int voteCount = -111;

        // act
        Response actual = partyController.createParty(partyName, voteCount);

        // assert
        assertEquals(expected, actual);
    }
}

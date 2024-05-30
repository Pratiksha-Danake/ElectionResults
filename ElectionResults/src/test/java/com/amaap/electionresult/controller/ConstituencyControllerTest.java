package com.amaap.electionresult.controller;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstituencyControllerTest {
    List<Party> parties = new ArrayList<Party>();
    private ConstituencyController constituencyController;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        constituencyController = injector.getInstance(ConstituencyController.class);
    }

    @BeforeEach
    void arrangeParties() throws FileNotFoundException, InvalidPartyDataException {
        parties.add(Party.create("INC", 100));
        parties.add(Party.create("CPI", 200));
        parties.add(Party.create("BJP", 300));
        parties.add(Party.create("NCP", 400));
        parties.add(Party.create("BSP", 500));
        parties.add(Party.create("IND", 600));
    }

    @Test
    void shouldBeAbleToReturnResponseAsOkIfCreatesConstituencySuccessfully() throws InvalidPartyDataException, FileNotFoundException {
        // arrange
        String constituencyName = "Pune";
        List<Party> parties = new ArrayList<Party>();
        parties.add(Party.create("INC", 100));
        parties.add(Party.create("CPI", 200));
        parties.add(Party.create("BJP", 300));
        parties.add(Party.create("NCP", 400));
        parties.add(Party.create("BSP", 500));
        parties.add(Party.create("IND", 600));
        Response expected = new Response(HttpStatus.OK, "CREATED");

        // act
        Response actual = constituencyController.createConstituency(constituencyName, parties);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnResponseAsBadRequestIfFailsToCreatesConstituency() throws FileNotFoundException {
        // arrange
        String constituencyName = "";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Data Provided");

        // act
        Response actual = constituencyController.createConstituency(constituencyName, parties);

        // assert
        assertEquals(expected, actual);
    }
}
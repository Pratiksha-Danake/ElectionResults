package com.amaap.electionresult.controller;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class ConstituencyControllerTest {
    private ConstituencyController constituencyController;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        constituencyController = injector.getInstance(ConstituencyController.class);
    }

    @Test
    void shouldBeAbleToReturnResponseAsOkIfCreatesConstituencySuccessfully() throws InvalidConstituencyNameException, InvalidPartyNameException, FileNotFoundException, InvalidVoteCountException {
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
    }
}
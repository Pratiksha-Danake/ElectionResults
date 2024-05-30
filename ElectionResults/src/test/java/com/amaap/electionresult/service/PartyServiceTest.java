package com.amaap.electionresult.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartyServiceTest {
    private PartyService partyService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        partyService = injector.getInstance(PartyService.class);
    }

    @Test
    void shouldBeAbleToCreateParty() throws InvalidPartyDataException, FileNotFoundException {
        // arrange
        String partyName = "BJP";
        int voteCount = 100;
        Party expected = Party.create(partyName, voteCount);

        // act
        Party actual = partyService.createParty(partyName, voteCount);

        // assert
        assertEquals(expected, actual);
    }
}
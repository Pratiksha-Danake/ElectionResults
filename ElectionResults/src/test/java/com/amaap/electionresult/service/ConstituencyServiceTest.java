package com.amaap.electionresult.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConstituencyServiceTest {
    private List<Party> constituencyParties;
    private ConstituencyService constituencyService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        constituencyService = injector.getInstance(ConstituencyService.class);
    }

    @BeforeEach()
    void arrangePartyData() throws InvalidPartyDataException, FileNotFoundException {
        // arrange
        constituencyParties = new ArrayList<Party>();
        constituencyParties.add(Party.create("INC", 1200));
        constituencyParties.add(Party.create("CPI", 7800));
        constituencyParties.add(Party.create("BJP", 300));
        constituencyParties.add(Party.create("NCP", 767));
        constituencyParties.add(Party.create("BSP", 500));
        constituencyParties.add(Party.create("IND", 800));
    }

    @Test
    void shouldBeAbleToCreateTheInstanceOfConstituency() throws InvalidPartyDataException, InvalidConstituencyNameException, FileNotFoundException {
        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();
        String name = "Pune";

        // act
        Constituency actual = constituencyService.createConstituency(name, constituencyParties);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowInvalidConstituencyNameExceptionIfConstituencyNameIsInvalid() {

        // act && assert
        assertThrows(InvalidConstituencyNameException.class, () -> {
            constituencyService.createConstituency("", constituencyParties);
        });

        assertThrows(InvalidConstituencyNameException.class, () -> {
            constituencyService.createConstituency(null, constituencyParties);
        });

        assertThrows(InvalidConstituencyNameException.class, () -> {
            constituencyService.createConstituency("ABC", constituencyParties);
        });
    }

    @Test
    void shouldBeAbleToGetConstituencies() throws InvalidConstituencyNameException, InvalidPartyDataException, FileNotFoundException {
        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();

        // act
        List<Constituency> constituencies = constituencyService.getConstituenciesData();

        // assert
        assertNotNull(constituencies);
    }
}
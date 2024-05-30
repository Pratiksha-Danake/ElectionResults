package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InMemoryConstituencyRepositoryTest {
    private InMemoryConstituencyRepository inMemoryConstituencyRepository;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryConstituencyRepository = injector.getInstance(InMemoryConstituencyRepository.class);
    }

    @Test
    void shouldBeAbleToAddConstituencyToTheDatabase() throws InvalidConstituencyNameException, InvalidPartyDataException, FileNotFoundException {
        // arrange
        Constituency constituency = ConstituencyBuilder.getConstituency();

        // act
        Constituency actual = inMemoryConstituencyRepository.addConstituency(constituency);

        // assert
        assertEquals(constituency, actual);
    }

    @Test
    void shouldBeAbleToGetConstituenciesFromTheDatabase() throws InvalidConstituencyNameException, InvalidPartyDataException, FileNotFoundException {
        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();

        // act
        List<Constituency> constituencies = inMemoryConstituencyRepository.getConstituenciesData();

        // assert
        assertNotNull(constituencies);

    }
}
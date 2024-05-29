package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FakeInMemoryDatabaseTest {
    private FakeInMemoryDatabase fakeInMemoryDatabase;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        fakeInMemoryDatabase = injector.getInstance(FakeInMemoryDatabase.class);
    }

    @Test
    void shouldBeAbleToAddConstituencyToTheDatabase() throws InvalidConstituencyNameException, InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange
        Constituency constituency = ConstituencyBuilder.getConstituency();

        // act
        Constituency actual = fakeInMemoryDatabase.addConstituency(constituency);

        // assert
        assertEquals(constituency, actual);
    }

    @Test
    void shouldBeAbleToGetConstituenciesFromTheDatabase() throws InvalidConstituencyNameException, InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();

        // act
        List<Constituency> constituencies = fakeInMemoryDatabase.getConstituencies();

        // assert
        assertNotNull(constituencies);

    }
}
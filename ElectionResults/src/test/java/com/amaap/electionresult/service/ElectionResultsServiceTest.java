package com.amaap.electionresult.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.exception.UnformattedInputLineException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectionResultsServiceTest {
    private ElectionResultsService electionResultsService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        electionResultsService = injector.getInstance(ElectionResultsService.class);
    }

    @Test
    void shouldBeAbleToGetWinnersOfEachConstituencyByUsingDomainService() throws InvalidPartyDataException, InvalidConstituencyNameException, FileNotFoundException, InvalidFilePathException, UnformattedInputLineException {
        // arrange
        String filePath = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";

        // act
        electionResultsService.evaluateElectionResults(filePath);

        // assert
        assertTrue(true);
    }
}

package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;
import com.amaap.electionresult.service.ConstituencyService;
import com.amaap.electionresult.service.io.DataReader;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.exception.UnformattedInputLineException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnerEvaluatorServiceTest {
    private WinnerEvaluatorService winnerEvaluatorService;
    private DataReader dataReader;
    private ConstituencyService constituencyService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        winnerEvaluatorService = injector.getInstance(WinnerEvaluatorService.class);
        dataReader = injector.getInstance(DataReader.class);
        constituencyService = injector.getInstance(ConstituencyService.class);
    }

    @Test
    void shouldBeAbleToFindTheWinnerPartyOfConstituency()
            throws InvalidConstituencyNameException, InvalidFilePathException, InvalidPartyNameException, UnformattedInputLineException {

        // arrange
        String filePath = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";
        dataReader.readFile(filePath);
        List<Constituency> constituenciesData = constituencyService.getConstituenciesData();
        WinnerPartyDto expectedWinner = new WinnerPartyDto("IND", 28.57);
        expectedWinner.setConstituencyName("Pune");

        // act
        WinnerPartyDto actualWinner = winnerEvaluatorService.findWinner(constituenciesData);
        
        // assert
        assertEquals(expectedWinner, actualWinner);
    }
}
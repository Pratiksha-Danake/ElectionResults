package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
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
            throws InvalidConstituencyNameException, InvalidFilePathException, InvalidPartyNameException, UnformattedInputLineException, InvalidVoteCountException {

        // arrange
        String filePath = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";
        dataReader.readFile(filePath);
        List<Constituency> constituenciesData = constituencyService.getConstituenciesData();

        WinnerPartyDto expectedWinner1 = new WinnerPartyDto("IND", 28.57);
        expectedWinner1.setConstituencyName("Pune");

        WinnerPartyDto expectedWinner2 = new WinnerPartyDto("BSP", 25.81);
        expectedWinner2.setConstituencyName("Chennai");

        List<WinnerPartyDto> expectedWinnerParties = List.of(expectedWinner1, expectedWinner2);


        // act
        List<WinnerPartyDto> actualWinnerParties = winnerEvaluatorService.findWinner(constituenciesData);

        // assert
        assertEquals(expectedWinnerParties, actualWinnerParties);
    }
}
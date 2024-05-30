package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.domain.service.WinnerEvaluatorService;
import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;
import com.amaap.electionresult.service.io.DataReader;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.exception.UnformattedInputLineException;
import com.google.inject.Inject;

import java.util.List;

public class ElectionResultsService {
    private DataReader dataReader;
    private ConstituencyService constituencyService;
    private WinnerEvaluatorService winnerEvaluatorService;
    private WinnerDetailsPrintingService winnerDetailsPrintingService;

    @Inject
    public ElectionResultsService(DataReader dataReader, ConstituencyService constituencyService, WinnerEvaluatorService winnerEvaluatorService, WinnerDetailsPrintingService winnerDetailsPrintingService) {
        this.dataReader = dataReader;
        this.constituencyService = constituencyService;
        this.winnerEvaluatorService = winnerEvaluatorService;
        this.winnerDetailsPrintingService = winnerDetailsPrintingService;
    }

    public void evaluateElectionResults(String filePath) throws InvalidConstituencyNameException, InvalidFilePathException, InvalidPartyDataException, UnformattedInputLineException {
        dataReader.readFile(filePath);
        List<Constituency> constituenciesData = constituencyService.getConstituenciesData();
        List<WinnerPartyDto> winners = winnerEvaluatorService.findWinner(constituenciesData);
        winnerDetailsPrintingService.print(winners);
    }
}

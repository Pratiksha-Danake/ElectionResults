package com.amaap.electionresult;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.service.ElectionResultsService;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.exception.UnformattedInputLineException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws InvalidConstituencyNameException, InvalidFilePathException, InvalidPartyDataException, UnformattedInputLineException {
        ElectionResultsService electionResultsService;
        Injector injector = Guice.createInjector(new AppModule());
        electionResultsService = injector.getInstance(ElectionResultsService.class);
        String electionDataFile = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";
        electionResultsService.evaluateElectionResults(electionDataFile);
    }
}

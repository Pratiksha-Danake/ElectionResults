package com.amaap.electionresult.domain.service.test;

import com.amaap.electionresult.domain.DataAnalyzer;
import com.amaap.electionresult.domain.exceptions.InvalidPartyException;
import com.amaap.electionresult.domain.model.ConstituencyResult;
import com.amaap.electionresult.domain.model.DataReader;
import com.amaap.electionresult.domain.service.WinnerDisplay;
import com.amaap.electionresult.io.file.DataSupplier;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class WinnerDisplayTest {
    DataSupplier dataSupplier = new DataSupplier();
    DataAnalyzer dataAnalyzer = new DataAnalyzer();
    DataReader dataReader = new DataReader();

    @Test
    void shouldAbleToDisplayDataOfWinnerPartyFromConstituency() throws InvalidPartyException {
        //Arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\ElectionResult.txt";
        File fileCreated = dataSupplier.getFile(pathToFile);
        List<ConstituencyResult> constituencyResult = dataReader.readData(fileCreated);
        List<WinnerDisplay> winners = dataAnalyzer.findWinner(constituencyResult);

    }
}

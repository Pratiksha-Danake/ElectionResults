package com.amaap.electionresult.domain.test;

import com.amaap.electionresult.domain.DataAnalyzer;
import com.amaap.electionresult.domain.exceptions.InvalidPartyException;
import com.amaap.electionresult.domain.model.ConstituencyResult;
import com.amaap.electionresult.domain.model.DataReader;
import com.amaap.electionresult.domain.service.WinnerDisplay;
import com.amaap.electionresult.io.file.DataSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class DataAnalyzerTest {
    DataSupplier dataSupplier = new DataSupplier();
    DataAnalyzer dataAnalyzer = new DataAnalyzer();
    DataReader dataReader = new DataReader();

    @Test
    void shouldAbleToAnalyzeDataAndFindWinnerFromAConstituency() throws InvalidPartyException {
        //Arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\ElectionResult.txt";
        int index = 0;
        List<String> expectedWinners = List.of("IND", "BSP");
        File fileCreated = dataSupplier.getFile(pathToFile);
        List<ConstituencyResult> constituencyResult = dataReader.readData(fileCreated);
        //Act
        List<WinnerDisplay> winners = dataAnalyzer.findWinner(constituencyResult);
        //Assert
        for (WinnerDisplay winner : winners) {
            Assertions.assertEquals(expectedWinners.get(index), winner.getWinnerPartyCode());
            index++;
        }
    }

    @Test
    void shouldAbleToThrowExceptionInvalidPartyExceptionWhenPartyDoesNotExists() throws InvalidPartyException {
        //Arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\Demo.txt";
        int index = 0;
        List<String> expectedWinners = List.of("IND", "BSP");
        File fileCreated = dataSupplier.getFile(pathToFile);
        List<ConstituencyResult> constituencyResult = dataReader.readData(fileCreated);

        //Act && Assert
        Assertions.assertThrows(InvalidPartyException.class, () -> {
            List<WinnerDisplay> winners = dataAnalyzer.findWinner(constituencyResult);
        });
    }

}

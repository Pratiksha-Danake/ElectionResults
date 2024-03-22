package com.org.election.test;

import com.org.election.domain.DataAnalyzer;
import com.org.election.io.file.DataSupplier;
import com.org.election.model.ConstituencyResult;
import com.org.election.model.DataReader;
import com.org.election.model.WinnerDisplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataAnalyzerTest {
    DataSupplier dataSupplier = new DataSupplier();
    DataAnalyzer dataAnalyzer = new DataAnalyzer();
    DataReader dataReader = new DataReader();

    @Test
    void shouldAbleToAnalyzeDataAndFindWinnerFromAConstituency(){
        //Arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\ElectionResult.txt";
        List<String> expectedWinners = List.of("IND","BSP");
        File fileCreated = dataSupplier.getFile(pathToFile);
        List<ConstituencyResult> constituencyResult = dataReader.readData(fileCreated);
        //Act
        List<WinnerDisplay> winners = dataAnalyzer.findWinner(constituencyResult);
        //Assert
        int index = 0;
        for (WinnerDisplay winner : winners){
            Assertions.assertEquals(expectedWinners.get(index),winner.getWinnerPartyCode());
            index++;
        }
    }
}

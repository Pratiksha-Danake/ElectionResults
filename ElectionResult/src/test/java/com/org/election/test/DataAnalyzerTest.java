package com.org.election.test;

import com.org.election.DataAnalyzer;
import com.org.election.DataSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataAnalyzerTest {
    DataSupplier dataSupplier = new DataSupplier();
    DataAnalyzer dataAnalyzer = new DataAnalyzer(dataSupplier);

    @Test
    @BeforeEach
    void setUp(){
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\ElectionResult.txt";
        dataSupplier.createFile(pathToFile);
    }

    @Test
    void shouldAbleToReadFileContainsElectionsData() throws FileNotFoundException {
        //Act
        dataAnalyzer.readData();
        //Assert
        assertTrue(true);
    }

    @Test
    void shouldAbleToGetTheFinalWinnerByAnalyzingData() {
        //Arrange
        String expectedWinner = "Independent";
        //Act
        String[] elctionData = dataAnalyzer.readData();
        for (int i = 0; i < elctionData.length; i++) {
            //Assert
            assertEquals("Independent", dataAnalyzer.showFinalWinner(elctionData));
        }
    }
}

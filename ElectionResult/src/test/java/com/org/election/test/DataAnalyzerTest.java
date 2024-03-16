package com.org.election.test;

import com.org.election.DataAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataAnalyzerTest {
    DataAnalyzer dataAnalyzer = new DataAnalyzer();

    @Test
    void shouldAbleToReadFileContainsElectionsData() throws FileNotFoundException {
        dataAnalyzer.readData();
        assertTrue(true);
    }

    @Test
    void shouldAbleToGetTheFinalWinnerByAnalyzingData(){
        String expectedWinner = "Indian National Congress";
        String[] parts = dataAnalyzer.readData();
        assertEquals(expectedWinner,dataAnalyzer.showFinalWinner(parts));
    }
}

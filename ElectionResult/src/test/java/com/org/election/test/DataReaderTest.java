package com.org.election.test;

import com.org.election.domain.DataReader;
import com.org.election.exceptions.InvalidPartyException;
import com.org.election.io.file.DataSupplier;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataReaderTest {
    DataSupplier dataSupplier = new DataSupplier();
    DataReader dataReader = new DataReader(dataSupplier);

    @Test
    void shouldAbleToReadFileContainsElectionsData() throws FileNotFoundException {
        //Arrange
        int expectedNoOfLineInFile = 2;
        File file = dataSupplier.getFile("E:\\ElectionResults\\ElectionResult\\ElectionResult.txt");
        //Act
        List<String> allConstituencyData = dataReader.readData(file);
        //Assert
        assertEquals(expectedNoOfLineInFile,allConstituencyData.size());
    }

    @Test
    void shouldAbleToProcessData() throws FileNotFoundException, InvalidPartyException {
        //Arrange
        File file = dataSupplier.getFile("E:\\ElectionResults\\ElectionResult\\ElectionResult.txt");
        List<String> allConstituencyData = dataReader.readData(file);
        //Act
        dataReader.processConstituenciesData(allConstituencyData);
        //Assert
        assertTrue(true);
    }

//    @Test
//    void shouldAbleToFormatData(){
//        //Arrange
//        String[] parts = new String[1];
//        parts[0] = "Pune, 100, INC, 200, CPI, 300, BJP, 400, NCP, 500, BSP, 600, IND";
////        DataReader.formatData(parts);
//    }
}

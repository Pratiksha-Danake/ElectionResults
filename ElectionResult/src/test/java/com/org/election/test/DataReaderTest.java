package com.org.election.test;

import com.org.election.io.file.DataSupplier;
import com.org.election.model.ConstituencyResult;
import com.org.election.model.DataReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataReaderTest {
    DataSupplier dataSupplier = new DataSupplier();
    DataReader dataReader = new DataReader();

    @Test
    void shouldAbleToReadFileContainsElectionsData() throws FileNotFoundException {
        //Arrange
        int expectedSize = 2;
        File file = dataSupplier.getFile("E:\\ElectionResults\\ElectionResult\\ElectionResult.txt");
        //Act
        List<ConstituencyResult> allConstituencyData = dataReader.readData(file);
        //Assert
        assertEquals(expectedSize,allConstituencyData.size());
    }
}

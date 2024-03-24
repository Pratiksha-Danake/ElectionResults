package com.amaap.electionresult.domain.model.test;

import com.amaap.electionresult.io.file.DataSupplier;
import com.amaap.electionresult.domain.model.ConstituencyResult;
import com.amaap.electionresult.domain.model.DataReader;
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

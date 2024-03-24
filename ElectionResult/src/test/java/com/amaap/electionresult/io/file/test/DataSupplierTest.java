package com.amaap.electionresult.io.file.test;

import com.amaap.electionresult.io.file.DataSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DataSupplierTest {
    DataSupplier dataSupplier = new DataSupplier();
    @Test
    void shouldAbleToCreateFileObjectForTheFileLocatedAtGivenPath(){
        //Arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\ElectionResult.txt";
        File resultFile = new File(pathToFile);
        //Act
        dataSupplier.getFile(pathToFile);
        //Assert
        Assertions.assertTrue(resultFile.exists());
    }
}

package com.org.election.test;

import com.org.election.DataSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DataSupplierTest {
    @Test
    void shouldAbleToCreateFileObjectForTheFileLocatedAtGivenPath(){
        //Arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResult\\ElectionResult.txt";
        DataSupplier dataSupplier = new DataSupplier();
        File resultFile = new File(pathToFile);
        //Act
        dataSupplier.createFile(pathToFile);
        //Assert
        Assertions.assertTrue(resultFile.exists());
    }
}

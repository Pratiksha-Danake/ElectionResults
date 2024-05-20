package com.amaap.electionresult.service.io;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataReadeTest {
    private DataReader dataReader;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        dataReader = injector.getInstance(DataReader.class);
    }

    @Test
    void shouldAbleToCreateFileObjectForTheFileLocatedAtGivenPath() throws IOException, InvalidFilePathException {
        //arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";

        //act && assert
        assertTrue(dataReader.readFile(pathToFile));
    }

    @Test
    void shouldThrowInvalidFilePathExceptionIfFilePathIsNull() throws IOException {
        //arrange
        String pathToFile = null;

        //act && assert
        assertThrows(InvalidFilePathException.class, () -> {
            dataReader.readFile(pathToFile);
        });
    }

    @Test
    void shouldThrowInvalidFilePathExceptionIfFilePathIsEmpty() throws IOException {
        //arrange
        String pathToFile = "";

        //act && assert
        assertThrows(InvalidFilePathException.class, () -> {
            dataReader.readFile(pathToFile);
        });
    }
}

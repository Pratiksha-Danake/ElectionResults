package com.amaap.electionresult.service.io;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import com.amaap.electionresult.service.ConstituencyService;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.exception.UnformattedInputLineException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataReadeTest {
    private DataReader dataReader;
    private DataParser dataParser;

    private ConstituencyService constituencyService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        dataReader = injector.getInstance(DataReader.class);
        dataParser = injector.getInstance(DataParser.class);
        constituencyService = injector.getInstance(ConstituencyService.class);
    }

    @Test
    void shouldAbleToCreateFileObjectForTheFileLocatedAtGivenPath() throws IOException, InvalidFilePathException, UnformattedInputLineException, InvalidPartyNameException {
        //arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";

        //act && assert
        assertTrue(dataReader.readFile(pathToFile));
    }

    @Test
    void shouldThrowInvalidFilePathExceptionIfFilePathIsNull() throws IOException {
        //arrange
        String filePath = null;

        //act && assert
        assertThrows(InvalidFilePathException.class, () -> {
            dataReader.readFile(filePath);
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

    @Test
    void shouldBeAbleToSendDataToTheParserToFindMeaningFullInsights() throws InvalidFilePathException, UnformattedInputLineException, InvalidPartyNameException, InvalidVoteCountException {
        //arrange
        String pathToFile = "E:\\ElectionResults\\ElectionResults\\src\\test\\java\\com\\amaap\\electionresult\\resource\\ResultData";
        List<Constituency> expected = ConstituencyBuilder.getConstituencies();

        // act
        dataReader.readFile(pathToFile);
        List<Constituency> actual = constituencyService.getConstituenciesData();

        // assert
        assertEquals(expected, actual);
    }
}

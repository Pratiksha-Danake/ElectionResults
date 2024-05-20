package com.amaap.electionresult.service.io;

import com.amaap.electionresult.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataParserTest {
    private DataParser dataParser;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        dataParser = injector.getInstance(DataParser.class);
    }

    @Test
    void shouldBeAbleToIgnoreNullInputLineTillTheEndOfTheFile(){
        // arrange
        String line = null;

        // act && assert
        assertTrue(dataParser.parseInputLine(line));
    }
}

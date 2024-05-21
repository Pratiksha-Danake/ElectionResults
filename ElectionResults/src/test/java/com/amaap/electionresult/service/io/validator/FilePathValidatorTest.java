package com.amaap.electionresult.service.io.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FilePathValidatorTest {
    @Test
    void shouldBeAbleToCreateTheInstanceOfFilaPathValidator() {
        // arrange && act
        FilePathValidator filePathValidator = new FilePathValidator();

        // assert
        assertNotNull(filePathValidator);
    }
}
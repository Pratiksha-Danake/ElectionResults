package com.amaap.electionresult.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static com.amaap.electionresult.domain.model.entity.validator.ConstituencyDataValidator.isInvalidConstituencyName;
import static org.junit.jupiter.api.Assertions.*;

class ConstituencyDataValidatorTest {

    @Test
    void shouldBeAbleToCreateTheInstanceOfFilaPathValidator() {
        // arrange && act
        ConstituencyDataValidator constituencyDataValidator = new ConstituencyDataValidator();

        // assert
        assertNotNull(constituencyDataValidator);
    }

    @Test
    void shouldBeAbleToValidateConstituencyNameByUsingConfigData() throws FileNotFoundException {
        // arrange
        String constituencyName = "Pune";

        // act && assert
        assertFalse(isInvalidConstituencyName(constituencyName));
        assertTrue(isInvalidConstituencyName("Solapur"));
    }
}
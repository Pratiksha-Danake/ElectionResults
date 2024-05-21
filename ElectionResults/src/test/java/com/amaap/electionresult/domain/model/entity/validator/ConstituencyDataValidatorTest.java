package com.amaap.electionresult.domain.model.entity.validator;

import com.amaap.electionresult.service.io.validator.FilePathValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstituencyDataValidatorTest {
    @Test
    void shouldBeAbleToCreateTheInstanceOfFilaPathValidator() {
        // arrange && act
        ConstituencyDataValidator constituencyDataValidator = new ConstituencyDataValidator();

        // assert
        assertNotNull(constituencyDataValidator);
    }
}
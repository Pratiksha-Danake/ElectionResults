package com.amaap.electionresult.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static com.amaap.electionresult.domain.model.entity.validator.PartyDataValidator.isInvalidPartyName;
import static org.junit.jupiter.api.Assertions.*;

class PartyDataValidatorTest {
    @Test
    void shouldBeAbleToCreateTheInstanceOfFilaPathValidator() {
        // arrange && act
        PartyDataValidator partyDataValidator = new PartyDataValidator();

        // assert
        assertNotNull(partyDataValidator);
    }

    @Test
    void shouldBeAbleToValidateThePartyNameByUsingConfigData() throws FileNotFoundException {
        // arrange && act
        String name = "BJP";
        int vote = 100;

        // assert
         assertFalse(isInvalidPartyName(name));
    }
}
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

    @Test
    void shouldBeAbleToValidatePartyName() throws FileNotFoundException {
        // act
        assertTrue(isInvalidPartyName(null));
        assertTrue(isInvalidPartyName(""));
        assertTrue(isInvalidPartyName("AB"));
        assertTrue(isInvalidPartyName("PQ"));
        assertTrue(isInvalidPartyName("XYZ"));
        assertFalse(isInvalidPartyName("INC"));
        assertFalse(isInvalidPartyName("BJP"));
        assertFalse(isInvalidPartyName("AAP"));
        assertTrue(isInvalidPartyName("XYZ"));
    }
}
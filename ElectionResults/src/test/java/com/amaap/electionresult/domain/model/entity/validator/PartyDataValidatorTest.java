package com.amaap.electionresult.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyDataValidatorTest {
    @Test
    void shouldBeAbleToCreateTheInstanceOfFilaPathValidator() {
        // arrange && act
        PartyDataValidator partyDataValidator = new PartyDataValidator();

        // assert
        assertNotNull(partyDataValidator);
    }
}
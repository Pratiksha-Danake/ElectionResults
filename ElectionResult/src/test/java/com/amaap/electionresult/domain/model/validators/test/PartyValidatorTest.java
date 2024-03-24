package com.amaap.electionresult.domain.model.validators.test;

import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.validators.PartyValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartyValidatorTest {
    PartyValidator partyValidator = new PartyValidator();

    @Test
    void shouldAbleToThrowInvalidPartyNameExceptionWhenPartyNameIsEmpty() {
        //Arrange
        String partyName = "";
        //Act && Assert
        Assertions.assertThrows(InvalidPartyNameException.class, () -> {
            partyValidator.isValidPartyName(partyName);
        });
    }

    @Test
    void shouldAbleToThrowInvalidPartyNameExceptionWhenPartyNameIsNull() {
        //Arrange
        String partyName = null;
        //Act && Assert
        Assertions.assertThrows(InvalidPartyNameException.class, () -> {
            partyValidator.isValidPartyName(partyName);
        });
    }

}

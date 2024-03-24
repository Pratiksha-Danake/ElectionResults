package com.amaap.electionresult.domain.model.validators.test;

import com.amaap.electionresult.domain.model.validators.PartyValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartyValidatorTest {

    @Test
    void shouldAbleToReturnFalseWhenPartyNameIsEmpty() {
        //Arrange
        String partyName = "";
        //Act && Assert
        Assertions.assertEquals(false, PartyValidator.isValidPartyName(partyName));
    }

    @Test
    void shouldAbleToReturnFalseWhenPartyNameIsNull() {
        //Arrange
        String partyName = null;
        //Act && Assert
        Assertions.assertEquals(false, PartyValidator.isValidPartyName(partyName));
    }

    @Test
    void shouldAbleToReturnTrueWhenPartyNameValid() {
        //Arrange
        String partyName = "Bhartiy Janta Party";
        //Act && Assert
        Assertions.assertEquals(true, PartyValidator.isValidPartyName(partyName));
    }

    @Test
    void shouldAbleToReturnFalseWhenPartyCodeIsEmpty() {
        //Arrange
        String partyCode = "";
        //Act && Assert
        Assertions.assertEquals(false, PartyValidator.isValidPartyCode(partyCode));
    }

    @Test
    void shouldAbleToReturnFalseWhenPartyCodeIsNull() {
        //Arrange
        String partyCode = null;
        //Act && Assert
        Assertions.assertEquals(false, PartyValidator.isValidPartyCode(partyCode));
    }

    @Test
    void shouldAbleToReturnTrueWhenPartyCodeValid() {
        //Arrange
        String partyCode = "BJP";
        //Act && Assert
        Assertions.assertEquals(true, PartyValidator.isValidPartyCode(partyCode));
    }
}

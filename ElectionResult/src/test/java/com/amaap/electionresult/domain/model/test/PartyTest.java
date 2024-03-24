package com.amaap.electionresult.domain.model.test;

import com.amaap.electionresult.domain.model.Party;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyCodeException;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartyTest {
    @Test
    void shouldAbleToThrowExceptionInvalidPartyNameExceptionWhenPartyNameIsEmpty() {
        //Arrange
        String partyName = "";
        String partyCode = "BJP";
        //Act && Assert
        Assertions.assertThrows(InvalidPartyNameException.class, () -> {
            Party.create(partyCode, partyName);
        });
    }

    @Test
    void shouldAbleToThrowInvalidPartyNameExceptionWhenPartyNameIsNull() {
        //Arrange
        String partyName = null;
        String partyCode = "BJP";
        //Act && Assert
        Assertions.assertThrows(InvalidPartyNameException.class, () -> {
            Party.create(partyCode, partyName);
        });
    }

    @Test
    void shouldAbleToThrowInvalidPartyCodeExceptionWhenPartyCodeIsEmpty() {
        //Arrange
        String partyName = "Bhartiy Janta Party";
        String partyCode = "";
        //Act && Assert
        Assertions.assertThrows(InvalidPartyCodeException.class, () -> {
            Party.create(partyCode, partyName);
        });
    }

    @Test
    void shouldAbleToThrowInvalidPartyCodeExceptionWhenPartyCodeIsNull() {
        //Arrange
        String partyName = "Bhartiy Janta Party";
        String partyCode = null;
        //Act && Assert
        Assertions.assertThrows(InvalidPartyCodeException.class, () -> {
            Party.create(partyCode, partyName);
        });
    }
}

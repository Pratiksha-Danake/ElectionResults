package com.amaap.electionresult.domain.model.test;

import com.amaap.electionresult.domain.model.Party;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElectionManagerTest {
    @Test
    void shouldAbleToCreatePartyWithGivenDetails() {
        //Arrange
        String partyCode = "BJP";
        String partyName = "Bhartiya Janta Party";
        Party expectedParty = new Party(partyCode, partyName);
        //Act
        Party actualParty = new Party(partyCode, partyName);
        //Assert
        Assertions.assertEquals(expectedParty, actualParty);
    }
}

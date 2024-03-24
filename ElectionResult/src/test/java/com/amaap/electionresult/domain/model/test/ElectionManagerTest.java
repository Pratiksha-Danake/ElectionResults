package com.amaap.electionresult.domain.model.test;

import com.amaap.electionresult.domain.model.ElectionManager;
import com.amaap.electionresult.domain.model.Party;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElectionManagerTest {
    ElectionManager electionManager = new ElectionManager();
    @Test
    void shouldAbleToCreatePartyWithGivenDetails() {
        //Arrange
        String partyCode = "BJP";
        String partyName = "Bhartiya Janta Party";
        Party expectedParty = Party.create(partyCode, partyName);
        //Act
        Party actualParty = electionManager.createParty(partyCode, partyName);
        //Assert
        Assertions.assertEquals(expectedParty, actualParty);
    }
}

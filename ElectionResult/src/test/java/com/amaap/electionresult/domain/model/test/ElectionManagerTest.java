package com.amaap.electionresult.domain.model.test;

import com.amaap.electionresult.domain.model.Constituency;
import com.amaap.electionresult.domain.model.ElectionManager;
import com.amaap.electionresult.domain.model.Party;
import com.amaap.electionresult.domain.model.exceptions.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyCodeException;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElectionManagerTest {
    ElectionManager electionManager = new ElectionManager();

    @Test
    void shouldAbleToCreatePartyWithGivenDetails() throws InvalidPartyNameException, InvalidPartyCodeException {
        //Arrange
        String partyCode = "BJP";
        String partyName = "Bhartiya Janta Party";
        Party expectedParty = Party.create(partyCode, partyName);
        //Act
        Party actualParty = electionManager.createParty(partyCode, partyName);
        //Assert
        Assertions.assertEquals(expectedParty, actualParty);
    }

    @Test
    void shouldAbleToAddvalidPartyToThePartyList() throws InvalidPartyNameException, InvalidPartyCodeException {
        //Arrange
        String partyCode = "BJP";
        String partyName = "Bhartiya Janta Party";
        Party partyToAdd = electionManager.createParty(partyCode, partyName);
        //Act
        electionManager.addParty(partyToAdd);
        //Assert
        Assertions.assertNotEquals(0, electionManager.getElectionParties().size());
    }

    @Test
    void shouldAbleToCreateConstituencyWithGivenName() throws InvalidConstituencyNameException {
        //Arrange
        String constituencyToCreate = "Pune";
        Constituency expectedConstituency = Constituency.create(constituencyToCreate);
        //Act
        Constituency actualConstituency = electionManager.createConstituency(constituencyToCreate);
        //Assert
        Assertions.assertEquals(expectedConstituency, actualConstituency);
    }

    @Test
    void shouldAbleToAddConstituencytoTheList() throws InvalidConstituencyNameException {
        //Arrange
        Constituency constituencyToAdd = Constituency.create("Pune");
        //Act
        electionManager.addConstituency(constituencyToAdd);
        //Assert
        Assertions.assertNotEquals(0, electionManager.getConstiuencies().size());
    }
}

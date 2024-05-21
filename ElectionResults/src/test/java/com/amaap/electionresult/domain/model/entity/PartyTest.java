package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    @Test
    void shouldBeAbleToCreateTheInstanceOfParty() throws InvalidPartyNameException, InvalidVoteCountException {
        // arrange
        String partyName = "BJP";
        int voteCount = 100;
        Party expected = Party.create(partyName, voteCount);

        // act
        Party actual = Party.create(partyName, voteCount);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowInvalidPartyNameExceptionIfPartyNameIsNotValid() {
        // arrange
        String partyName = "";
        int voteCount = 100;

        // act && assert
        assertThrows(InvalidPartyNameException.class, () -> {
            Party.create(partyName, voteCount);
        });

        assertThrows(InvalidPartyNameException.class, () -> {
            Party.create(null, voteCount);
        });

        assertThrows(InvalidPartyNameException.class, () -> {
            Party.create("AB", voteCount);
        });
    }

    @Test
    void shouldThrowInvalidVoteCountExceptionIfVoteCountIsInvalid() {
        // arrange
        String partyName = "BJP";
        int voteCount = 0;

        // act && assert
        assertThrows(InvalidVoteCountException.class, () -> {
            Party.create(partyName, voteCount);
        });

        assertThrows(InvalidVoteCountException.class, () -> {
            Party.create(partyName, -100);
        });
    }

    @Test
    void shouldBeAbleToReturnTheHashCode() throws InvalidPartyNameException, InvalidVoteCountException {
        // arrange && act
        Party party1 = Party.create("BJP", 100);
        Party party2 = Party.create("INC", 100);

        // assert
        assertNotEquals(party1.hashCode(), party2.hashCode());
    }

    @Test
    void shouldBeAbleToTestTheEqualityOfTwoInstancesOfPartyClass() throws InvalidPartyNameException, InvalidVoteCountException {
        // arrange
        Party party1 = Party.create("BJP", 100);
        Party party2 = Party.create("INC", 100);
        Party party3 = Party.create("INC", 200);
        Party party4 = Party.create("INC", 100);


        // act && assert
        assertFalse(party1.equals(null));
        assertTrue(party1.equals(party1));
        assertFalse(party1.equals(new Object()));

        assertFalse(party2.equals(party3));
        assertFalse(party1.equals(party3));
        assertTrue(party2.equals(party4));
        assertFalse(party1.equals(party2));
    }
}
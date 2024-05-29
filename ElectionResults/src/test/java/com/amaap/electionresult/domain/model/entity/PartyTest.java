package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    @Test
    void shouldBeAbleToCreateTheInstanceOfParty() throws InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
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
    void shouldBeAbleToReturnTheHashCode() throws InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange && act
        Party party1 = Party.create("BJP", 100);
        Party party2 = Party.create("INC", 100);

        // assert
        assertNotEquals(party1.hashCode(), party2.hashCode());
    }

    @Test
    void shouldBeAbleToTestTheEqualityOfTwoInstancesOfPartyClass() throws InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange
        Party party1 = Party.create("BJP", 100);
        Party party2 = Party.create("INC", 100);
        Party party3 = Party.create("INC", 200);
        Party party4 = Party.create("INC", 100);


        // act && assert
        assertNotEquals(null, party1);
        assertEquals(party1, party1);
        assertNotEquals(party1, new Object());

        assertNotEquals(party2, party3);
        assertNotEquals(party1, party3);
        assertEquals(party2, party4);
        assertNotEquals(party1, party2);
    }
}
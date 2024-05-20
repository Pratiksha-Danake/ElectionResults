package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
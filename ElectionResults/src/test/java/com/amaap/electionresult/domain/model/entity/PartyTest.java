package com.amaap.electionresult.domain.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartyTest {

    @Test
    void shouldBeAbleToCreateTheInstanceOfParty() {
        // arrange
        String partyName = "BJP";
        int voteCount = 100;
        Party expected = Party.create(partyName, voteCount);

        // act
        Party actual = Party.create(partyName, voteCount);

        // assert
        assertEquals(expected, actual);
    }
}
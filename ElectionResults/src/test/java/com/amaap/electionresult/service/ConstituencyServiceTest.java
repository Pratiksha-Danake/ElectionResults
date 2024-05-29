package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConstituencyServiceTest {
    private List<Party> constituencyParties;

    @BeforeEach()
    void arrangePartyData() throws InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange
        constituencyParties = new ArrayList<Party>();
        constituencyParties.add(Party.create("INC", 1200));
        constituencyParties.add(Party.create("CPI", 7800));
        constituencyParties.add(Party.create("BJP", 300));
        constituencyParties.add(Party.create("NCP", 767));
        constituencyParties.add(Party.create("BSP", 500));
        constituencyParties.add(Party.create("IND", 800));
    }

    @Test
    void shouldBeAbleToCreateTheInstanceOfConstituency() throws InvalidPartyNameException, InvalidVoteCountException, InvalidConstituencyNameException, FileNotFoundException {
        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();
        String name = "Pune";

        // act
        Constituency actual = Constituency.create(name, constituencyParties);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowInvalidConstituencyNameExceptionIfConstituencyNameIsInvalid() {

        // act && assert
        assertThrows(InvalidConstituencyNameException.class, () -> {
            Constituency.create("", constituencyParties);
        });

        assertThrows(InvalidConstituencyNameException.class, () -> {
            Constituency.create(null, constituencyParties);
        });

        assertThrows(InvalidConstituencyNameException.class, () -> {
            Constituency.create("ABC", constituencyParties);
        });
    }
}
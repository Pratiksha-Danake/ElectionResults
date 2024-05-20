package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConstituencyTest {
    @Test
    void shouldBeAbleToCreateTheInstanceOfConstituency() throws InvalidPartyNameException, InvalidVoteCountException, InvalidConstituencyNameException {
        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();
        List<Party> constituencyParties = new ArrayList<Party>();
        constituencyParties.add(Party.create("INC", 100));
        constituencyParties.add(Party.create("CPI", 200));
        constituencyParties.add(Party.create("BJP", 300));
        constituencyParties.add(Party.create("NCP", 400));
        constituencyParties.add(Party.create("BSP", 500));
        constituencyParties.add(Party.create("IND", 600));
        String name = "Pune";

        // act
        Constituency actual = Constituency.create(name, constituencyParties);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowInvalidConstituencyNameExceptionIfConstituencyNameIsInvalid() throws
            InvalidPartyNameException, InvalidVoteCountException, InvalidConstituencyNameException {

        // arrange
        Constituency expected = ConstituencyBuilder.getConstituency();
        List<Party> constituencyParties = new ArrayList<Party>();
        constituencyParties.add(Party.create("INC", 100));
        constituencyParties.add(Party.create("CPI", 200));
        constituencyParties.add(Party.create("BJP", 300));
        constituencyParties.add(Party.create("NCP", 400));
        constituencyParties.add(Party.create("BSP", 500));
        constituencyParties.add(Party.create("IND", 600));
        String name = "";

        // act && assert
        assertThrows(InvalidConstituencyNameException.class, () -> {
            Constituency actual = Constituency.create(name, constituencyParties);
        });
    }
}
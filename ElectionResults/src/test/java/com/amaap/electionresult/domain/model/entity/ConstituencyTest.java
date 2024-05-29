package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;
import com.amaap.electionresult.util.ConstituencyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConstituencyTest {
    private List<Party> constituencyParties;

    @BeforeEach()
    void arrangePartyData() throws InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange
        constituencyParties = new ArrayList<Party>();
        constituencyParties.add(Party.create("INC", 100));
        constituencyParties.add(Party.create("CPI", 200));
        constituencyParties.add(Party.create("BJP", 300));
        constituencyParties.add(Party.create("NCP", 400));
        constituencyParties.add(Party.create("BSP", 500));
        constituencyParties.add(Party.create("IND", 600));
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

    @Test
    void shouldBeAbleReturnHashCode() throws InvalidConstituencyNameException, InvalidPartyNameException, InvalidVoteCountException, FileNotFoundException {
        // arrange
        Constituency constituency1 = Constituency.create("Pune", constituencyParties);
        List<Party> parties = new ArrayList<Party>();
        constituencyParties.add(Party.create("INC", 100));
        constituencyParties.add(Party.create("CPI", 200));
        constituencyParties.add(Party.create("BJP", 300));
        constituencyParties.add(Party.create("NCP", 400));
        constituencyParties.add(Party.create("BSP", 500));
        constituencyParties.add(Party.create("IND", 600));
        Constituency constituency2 = Constituency.create("Chennai", parties);

        // act && assert
        assertNotEquals(constituency1.hashCode(), constituency2.hashCode());
    }

    @Test
    void shouldBeAbleToAssertTheEqualityOfTwoInstances() throws InvalidConstituencyNameException, FileNotFoundException {
        // arrange
        Constituency constituency = Constituency.create("Pune", constituencyParties);

        // act && assert
        assertTrue(constituency.equals(constituency));
        assertFalse(constituency.equals(null));
        assertFalse(constituency.equals(new Object()));
    }
}
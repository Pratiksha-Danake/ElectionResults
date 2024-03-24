package com.amaap.electionresult.domain.model.test;

import com.amaap.electionresult.domain.model.Constituency;
import com.amaap.electionresult.domain.model.exceptions.InvalidConstituencyNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstituencyTest {
    @Test
    void shouldAbleToCreateConstituencyWithGivenName() throws InvalidConstituencyNameException {
        //Arrange
        String constituencyToCreate = "Pune";
        Constituency expectedConstituency = Constituency.create(constituencyToCreate);
        //Act
        Constituency actualConstituency = Constituency.create(constituencyToCreate);
        //Assert
        Assertions.assertEquals(expectedConstituency, actualConstituency);
    }

    @Test
    void shouldAbleToThrowInvalidConstituencyNameExceptionWhenConstituencyNameIsNull() {
        //Arrange
        String constituencyToCreate = null;
        //Act && Assert
        Assertions.assertThrows(InvalidConstituencyNameException.class, () -> {
            Constituency.create(constituencyToCreate);
        });
    }

    @Test
    void shouldAbleToThrowInvalidConstituencyNameExceptionWhenConstituencyNameIsEmpty() {
        //Arrange
        String constituencyToCreate = "";
        //Act && Assert
        Assertions.assertThrows(InvalidConstituencyNameException.class, () -> {
            Constituency.create(constituencyToCreate);
        });
    }
}

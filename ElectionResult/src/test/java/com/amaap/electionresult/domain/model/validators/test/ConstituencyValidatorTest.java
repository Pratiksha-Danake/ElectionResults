package com.amaap.electionresult.domain.model.validators.test;

import com.amaap.electionresult.domain.model.validators.ConstituencyValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstituencyValidatorTest {
    @Test
    void shouldAbleToReturnFalseWhenConstituencyNameIsEmpty() {
        //Arrange
        String constituencyName = "";
        //Assert
        Assertions.assertFalse(ConstituencyValidator.isValidConstituency(constituencyName));
    }

    @Test
    void shouldAbleToReturnFalseWhenConstituencyNameIsNull() {
        //Arrange
        String constituencyName = null;
        //Assert
        Assertions.assertFalse(ConstituencyValidator.isValidConstituency(constituencyName));
    }

    @Test
    void shouldAbleToReturnTrueWhenConstituencyNameIsValid(){
        //Arrange
        String constituencyName = "Pune";
        //Assert
        Assertions.assertTrue(ConstituencyValidator.isValidConstituency(constituencyName));
    }
}

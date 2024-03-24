package com.amaap.electionresult.domain.model.validators;

public class ConstituencyValidator {

    public static boolean isValidConstituency(String constituencyName) {
        if (constituencyName == null || constituencyName.isEmpty())
            return false;
        return true;
    }
}

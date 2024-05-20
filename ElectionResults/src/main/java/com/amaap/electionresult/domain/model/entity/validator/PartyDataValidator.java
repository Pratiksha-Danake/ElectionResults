package com.amaap.electionresult.domain.model.entity.validator;

public class PartyDataValidator {
    public static boolean isInvalidPartyName(String name) {
        if (name == null || name.equals(""))
            return true;
        return false;
    }
}

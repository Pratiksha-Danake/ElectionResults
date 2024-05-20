package com.amaap.electionresult.domain.model.entity.validator;

public class PartyDataValidator {
    public static boolean isInvalidPartyName(String name) {
        if (name == null || name.equals("") || !(name.matches("^[a-zA-Z]{3,}$")))
            return true;
        return false;
    }

    public static boolean isInvalidVoteCount(int vote) {
        if (vote <= 0)
            return true;
        return false;
    }
}

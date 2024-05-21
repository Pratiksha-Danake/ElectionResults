package com.amaap.electionresult.domain.model.entity.validator;

public class PartyDataValidator {
    public static boolean isInvalidPartyName(String name) {
        return name == null || name.equals("") || !(name.matches("^[a-zA-Z]{3,}$"));
    }

    public static boolean isInvalidVoteCount(int vote) {
        return vote <= 0;
    }
}

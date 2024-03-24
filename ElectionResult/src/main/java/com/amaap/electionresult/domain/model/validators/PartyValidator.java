package com.amaap.electionresult.domain.model.validators;

public class PartyValidator {

    public static boolean isValidPartyName(String partyName){
        if (partyName == null || partyName.isEmpty())
            return false;
        return true;
    }

    public static boolean isValidPartyCode(String partyCode) {
        if (partyCode == null || partyCode.isEmpty())
            return false;
        return true;
    }
}

package com.amaap.electionresult.service.valueobject;

public class PartyCodeConverter {
    public static final String getPartyFullName(String partyCode) {
        String fullName = "";
        switch (partyCode) {
            case "BJP":
                fullName = "Bhartiya Janta Party";
                break;
            case "INC":
                fullName = "Indian National Congress";
                break;
            case "BSP":
                fullName = "Bahujan Samaj Party";
                break;
            case "CPI":
                fullName = "Communist Party of India";
                break;
            case "NCP":
                fullName = "Nationalist Congress Party";
                break;
            case "IND":
                fullName = "Independent";
                break;
        }
        return fullName;
    }
}

package com.amaap.electionresult.domain.model.entity.validator;

public class ConstituencyDataValidator {
    public static boolean isInvalidConstituencyName(String name) {
        return name == null || name.equals("") || !(name.matches("^[a-zA-Z]{4,}$"));
    }
}

package com.amaap.electionresult.domain.model;

import java.util.Objects;

public class Party {
    private String code;
    private String name;

    private Party(String partyCode, String partyName) {
        this.code = code;
        this.name = name;
    }

    public static Party create(String partyCode, String partyName) {
        return new Party(partyCode, partyName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return Objects.equals(code, party.code) && Objects.equals(name, party.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}

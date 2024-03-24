package com.amaap.electionresult.domain.model;

import java.util.Objects;

public class Constituency {
    private String constituency;

    public Constituency(String constituencyName) {
        this.constituency = constituencyName;
    }

    public static Constituency create(String constituencyName) {
        return new Constituency(constituencyName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constituency that = (Constituency) o;
        return Objects.equals(constituency, that.constituency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constituency);
    }
}

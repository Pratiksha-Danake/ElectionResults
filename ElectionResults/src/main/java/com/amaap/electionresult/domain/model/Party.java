package com.amaap.electionresult.domain.model;

import java.util.Objects;

public class Party {
    private String name;
    private int vote;

    public Party(String name, int vote) {
        this.name = name;
        this.vote = vote;
    }

    public static Party create(String name, int vote) {
        return new Party(name, vote);
    }

    public String getName() {
        return name;
    }

    public int getVote() {
        return vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return vote == party.vote && Objects.equals(name, party.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vote);
    }
}

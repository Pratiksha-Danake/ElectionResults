package com.org.election.domain;

import com.org.election.PartyCodeConverter;
import com.org.election.io.file.DataSupplier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataAnalyzer {
    DataSupplier dataSupplier;
    static final int totalVotes = 2100;
    public DataAnalyzer(DataSupplier dataSupplier) {
        this.dataSupplier = dataSupplier;
    }

    public String[] readData() {
        String[] parts = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader(dataSupplier.getResultFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                parts = line.split(", ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parts;
    }

    public String showFinalWinner(String[] constituencyData) {
        String constituency = constituencyData[0];
        String winner = getWinner(constituencyData);
        System.out.println( constituency + " Constituency "+": "+ winner);
        return winner;
    }

    private static String getWinner(String[] parts) {
        int maxVotes = 0;
        String winner = "";
        for (int i = 1; i < parts.length; i += 2) {
            int votes = Integer.parseInt(parts[i]);
            if (votes > maxVotes) {
                maxVotes = votes;
                winner = PartyCodeConverter.getPartyFullName(parts[i+1]);
            }
        }
        return winner;
    }

    public double getPercantageOfVotesCast() {
        return 0;
    }
}

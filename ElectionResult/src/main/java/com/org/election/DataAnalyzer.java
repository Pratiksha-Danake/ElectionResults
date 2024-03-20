package com.org.election;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataAnalyzer {
    DataSupplier dataSupplier;

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
                winner = getPartyFullName(parts[i+1]);
            }
        }
        return winner;
    }

    private static String getPartyFullName(String partyCode) {
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

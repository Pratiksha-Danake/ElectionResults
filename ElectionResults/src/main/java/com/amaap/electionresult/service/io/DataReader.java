package com.amaap.electionresult.service.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public boolean readFile(String pathToFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}

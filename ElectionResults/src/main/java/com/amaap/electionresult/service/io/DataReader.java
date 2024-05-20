package com.amaap.electionresult.service.io;

import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.validator.FilePathValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.amaap.electionresult.service.io.validator.FilePathValidator.isInvalidPath;

public class DataReader {
    public boolean readFile(String filePath) throws InvalidFilePathException {
        if (isInvalidPath(filePath))
            throw new InvalidFilePathException("File Path Can't be.." + filePath);
        else {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}

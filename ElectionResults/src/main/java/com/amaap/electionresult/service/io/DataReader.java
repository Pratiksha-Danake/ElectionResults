package com.amaap.electionresult.service.io;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.service.io.exception.InvalidFilePathException;
import com.amaap.electionresult.service.io.exception.UnformattedInputLineException;
import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import static com.amaap.electionresult.service.io.validator.FilePathValidator.isInvalidPath;

public class DataReader {
    private final DataParser dataParser;

    @Inject
    public DataReader(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    public boolean readFile(String filePath) throws InvalidFilePathException, UnformattedInputLineException, InvalidPartyDataException, InvalidConstituencyNameException {
        if (isInvalidPath(filePath)) {
            throw new InvalidFilePathException("File Path Can't be " + filePath);
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty())
                        continue;
                    if ((Pattern.matches("^([\\w\\s]+)(?:,\\s*(\\w+),\\s*(\\d+))+$", line)))
                        dataParser.parseInputLine(line);
                    else
                        throw new UnformattedInputLineException("Poorly Formatted Input Line " + line);
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}

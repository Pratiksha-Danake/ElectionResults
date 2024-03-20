package com.org.election;

import java.io.File;

public class DataSupplier {
    private File resultFile;

    public File getResultFile() {
        return resultFile;
    }

    public void createFile(String pathToFileContainsElectionData) {
        resultFile  = new File(pathToFileContainsElectionData);
    }
}

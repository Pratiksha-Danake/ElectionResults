package com.org.election.io.file;

import java.io.File;

public class DataSupplier {
    private File resultFile;

    public File getResultFile() {
        return resultFile;
    }

    public void getFile(String pathToFileContainsElectionData) {
        resultFile  = new File(pathToFileContainsElectionData);
    }
}

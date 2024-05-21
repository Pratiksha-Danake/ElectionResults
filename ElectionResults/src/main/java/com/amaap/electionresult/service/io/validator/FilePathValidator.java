package com.amaap.electionresult.service.io.validator;

public class FilePathValidator {
    public static boolean isInvalidPath(String filePath) {
        return filePath == null || filePath.equals("");
    }
}

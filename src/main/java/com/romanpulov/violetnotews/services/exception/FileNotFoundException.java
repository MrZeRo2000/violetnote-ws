package com.romanpulov.violetnotews.services.exception;

public class FileNotFoundException extends Exception {

    private static String composeMessage(String fileName) {
        return "File not found: " + fileName;
    }

    public FileNotFoundException(String fileName) {
        super(FileNotFoundException.composeMessage(fileName));
    }

    public FileNotFoundException(String fileName, Throwable cause) {
        super(FileNotFoundException.composeMessage(fileName), cause);
    }
}

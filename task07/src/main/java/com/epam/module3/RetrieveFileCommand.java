package com.epam.module3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
public class RetrieveFileCommand implements Command {
    private final Scanner scanner;

    @Override
    public void execute(FileService fileService) throws SQLException {
        System.out.print("Enter file ID to retrieve: ");
        long fileId = scanner.nextLong();
        File file = fileService.retrieveFile(fileId);
        System.out.println("File Name: " + file.fileName());
        System.out.println("File Type: " + file.fileType());
    }
}


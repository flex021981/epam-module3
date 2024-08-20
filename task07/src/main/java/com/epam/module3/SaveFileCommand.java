package com.epam.module3;

import lombok.RequiredArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

@RequiredArgsConstructor
public class SaveFileCommand implements Command {
    private final Scanner scanner;

    @Override
    public void execute(FileService fileService) throws SQLException, IOException {
        System.out.print("Enter file name: ");
        String fileName = scanner.next();
        System.out.print("Enter file type: ");
        String fileType = scanner.next();
        System.out.print("Enter expiration date (yyyy-mm-dd hh:mm:ss): ");
        String expirationDate = scanner.next();
        Timestamp expirationAt = Timestamp.valueOf(expirationDate);

        System.out.print("Enter file path: ");
        String filePath = scanner.next();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            fileService.saveFile(fileName, fileType, fis, expirationAt);
            System.out.println("File saved successfully.");
        }
    }
}


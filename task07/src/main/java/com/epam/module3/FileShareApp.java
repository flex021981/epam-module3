package com.epam.module3;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

@Slf4j
public class FileShareApp {

    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getInstance().createConnection()) {
            FileDao fileDao = new FileDaoImpl(connection);
            FileService fileService = FileService.getInstance(fileDao);
            Scanner scanner = new Scanner(System.in);
            CommandManager commandManager = new CommandManager(scanner);

            commandManager.registerCommand(1, new SaveFileCommand(scanner));
            commandManager.registerCommand(2, new RetrieveFileCommand(scanner));

            System.out.println("1. Save File");
            System.out.println("2. Retrieve File");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            commandManager.executeCommand(choice, fileService);
        } catch (SQLException | IOException e) {
            log.error("An error occurred: ", e);
        }
    }
}
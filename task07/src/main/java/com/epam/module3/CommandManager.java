package com.epam.module3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
public class CommandManager {
    private final Map<Integer, Command> commands = new HashMap<>();
    private final Scanner scanner;

    public void registerCommand(int option, Command command) {
        commands.put(option, command);
    }

    public void executeCommand(int option, FileService fileService) throws SQLException, IOException {
        Command command = commands.get(option);
        if (command != null) {
            command.execute(fileService);
        } else {
            log.error("Invalid option: {}", option);
        }
    }
}


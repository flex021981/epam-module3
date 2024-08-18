package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class DiskAnalyzerService {

    public Optional<String> getPath(String[] args) {
        if (args == null || args.length != 2) {
            log.info("No arguments provided, using default path.");
            return Optional.empty();
        }
        return Optional.of(args[0]);
    }

    public Optional<Integer> getFunctionNumber(String[] args) {
        if (args == null || args.length != 2) {
            return Optional.empty();
        }
        try {
            return Optional.of(Integer.parseInt(args[1]));
        } catch (NumberFormatException e) {
            log.error("Invalid function number: {}", args[1], e);
            return Optional.empty();
        }
    }
}

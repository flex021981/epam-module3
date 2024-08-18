package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class ResultWriter {
    private static final String RESULT_FILE = "disk_analyzer_result.txt";

    public void writeResult(String content) {
        try (FileWriter writer = new FileWriter(RESULT_FILE)) {
            writer.write(content);
            log.info("Result written to {}", RESULT_FILE);
        } catch (IOException e) {
            log.error("Failed to write result to {}", RESULT_FILE, e);
        }
    }

}

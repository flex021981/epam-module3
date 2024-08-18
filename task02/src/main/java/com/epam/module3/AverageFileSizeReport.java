package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class AverageFileSizeReport implements ReportStrategy {
    private final ResultWriter resultWriter = new ResultWriter();

    @Override
    public void getReport(String path) {
        try (Stream<Path> filePathStream = Files.walk(Path.of(path))) {
            List<Long> fileSizes = filePathStream
                    .filter(Files::isRegularFile)
                    .map(p -> p.toFile().length())
                    .toList();

            if (!fileSizes.isEmpty()) {
                double averageSize = fileSizes.stream().mapToLong(Long::longValue).average().orElse(0);
                resultWriter.writeResult("Average file size: " + averageSize + " bytes");
                log.info("Average file size was found successfully: {} bytes", averageSize);
            } else {
                resultWriter.writeResult("No files found.");
            }
        } catch (IOException e) {
            log.error("An error occurred while executing AverageFileSizeStrategy.", e);
        }
    }
}

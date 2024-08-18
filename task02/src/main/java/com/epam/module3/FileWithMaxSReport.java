package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class FileWithMaxSReport implements ReportStrategy {
    private final ResultWriter resultWriter = new ResultWriter();

    @Override
    public void getReport(String path) {
        try (Stream<Path> filePathStream = Files.walk(Path.of(path))) {
            Optional<Path> result = filePathStream
                    .filter(Files::isRegularFile)
                    .max(Comparator.comparingLong(p -> p.getFileName().toString().chars().filter(ch -> ch == 's').count()));

            result.ifPresentOrElse(
                    p -> {
                        resultWriter.writeResult("Max 's' count file: " + p.toAbsolutePath());
                        log.info("Max 's' count file was found successfully: {}", p);
                    },
                    () -> resultWriter.writeResult("No files found.")
            );
        } catch (IOException e) {
            log.error("An error occurred while executing FileWithMaxSStrategy.", e);
        }
    }
}

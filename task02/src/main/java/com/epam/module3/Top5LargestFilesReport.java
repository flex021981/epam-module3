package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Top5LargestFilesReport implements ReportStrategy {
    private final ResultWriter resultWriter = new ResultWriter();

    @Override
    public void getReport(String path) {
        try (Stream<Path> filePathStream = Files.walk(Path.of(path))) {
            List<Path> largestFiles = filePathStream
                    .filter(Files::isRegularFile)
                    .sorted(Comparator.comparingLong(p -> -p.toFile().length()))
                    .limit(5)
                    .toList();

            StringBuilder result = new StringBuilder("Top 5 largest files:\n");
            for (Path file : largestFiles) {
                result.append(file.toAbsolutePath())
                        .append(" (")
                        .append(file.toFile().length())
                        .append(" bytes)\n");
            }

            resultWriter.writeResult(result.toString());
            log.info("Top 5 largest files were found successfully: {}", result);
        } catch (IOException e) {
            log.error("An error occurred while executing Top5LargestFilesStrategy.", e);
        }
    }
}

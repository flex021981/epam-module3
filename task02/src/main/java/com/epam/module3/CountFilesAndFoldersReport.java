package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class CountFilesAndFoldersReport implements ReportStrategy {
    private final ResultWriter resultWriter = new ResultWriter();

    @Override
    public void getReport(String path) {
        Map<Character, int[]> alphabetMap = new HashMap<>();

        try (Stream<Path> filePathStream = Files.walk(Path.of(path))) {
            filePathStream.forEach(p -> {
                char firstChar = Character.toUpperCase(p.getFileName().toString().charAt(0));
                alphabetMap.putIfAbsent(firstChar, new int[]{0, 0});
                if (Files.isRegularFile(p)) {
                    alphabetMap.get(firstChar)[0]++;
                } else if (Files.isDirectory(p)) {
                    alphabetMap.get(firstChar)[1]++;
                }
            });

            StringBuilder result = new StringBuilder("Files and folders count by alphabet:\n");
            for (Map.Entry<Character, int[]> entry : alphabetMap.entrySet()) {
                result.append(entry.getKey()).append(": ")
                        .append(entry.getValue()[0]).append(" files, ")
                        .append(entry.getValue()[1]).append(" folders\n");
            }

            resultWriter.writeResult(result.toString());
            log.info("Files and folders count by alphabet were found successfully: {}", result);
        } catch (IOException e) {
            log.error("An error occurred while executing CountFilesAndFoldersStrategy.", e);
        }
    }
}

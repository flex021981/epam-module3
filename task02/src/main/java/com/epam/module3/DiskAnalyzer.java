package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class DiskAnalyzer {
    private static final Configuration config = Configuration.getInstance();
    private static final DiskAnalyzerService diskAnalyzerService = new DiskAnalyzerService();

    public static void main(String[] args) {
        Optional<String> pathOpt = diskAnalyzerService.getPath(args);
        Optional<Integer> functionNumberOpt = diskAnalyzerService.getFunctionNumber(args);
        String path = pathOpt.orElse(config.getDefaultPath());
        int functionNumber = functionNumberOpt.orElse(config.getDefaultFunctionNumber());

        log.info("Usage: java DiskAnalyzer <{}> <{}>", path, functionNumber);

        ReportStrategy report = ReportStrategyFactory.getReport(functionNumber);
        if (report == null) {
            log.error("Invalid function number: {}", functionNumber);
            return;
        }

        report.getReport(path);
    }
}
package com.epam.module3;

public interface ReportStrategyFactory {

    static ReportStrategy getReport(int functionNumber) {
        return switch (functionNumber) {
            case 1 -> new FileWithMaxSReport();
            case 2 -> new Top5LargestFilesReport();
            case 3 -> new AverageFileSizeReport();
            case 4 -> new CountFilesAndFoldersReport();
            default -> null;
        };
    }
}

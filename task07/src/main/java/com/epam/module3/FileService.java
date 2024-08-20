package com.epam.module3;

import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FileService {
    private static FileService instance;
    private final FileDao fileDao;

    private FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public static synchronized FileService getInstance(FileDao fileDao) {
        if (instance == null) {
            instance = new FileService(fileDao);
        }
        return instance;
    }

    public void saveFile(String fileName, String fileType, InputStream fileData, Timestamp expirationAt) throws SQLException {
        fileDao.saveFile(fileName, fileType, fileData, expirationAt);
    }

    public File retrieveFile(long fileId) throws SQLException {
        return fileDao.retrieveFile(fileId);
    }
}

package com.epam.module3;

import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;

public interface FileDao {
    void saveFile(String fileName, String fileType, InputStream fileData, Timestamp expirationAt) throws SQLException;

    File retrieveFile(long fileId) throws SQLException;
}

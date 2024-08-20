package com.epam.module3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.sql.*;

@Slf4j
@RequiredArgsConstructor
public class FileDaoImpl implements FileDao {
    private final Connection connection;

    @Override
    public void saveFile(String fileName, String fileType, InputStream fileData, Timestamp expirationAt) throws SQLException {
        String sql = "{CALL save_file(?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, fileName);
            stmt.setString(2, fileType);
            stmt.setBlob(3, fileData);
            stmt.setTimestamp(4, expirationAt);
            stmt.execute();
        }
    }

    @Override
    public File retrieveFile(long fileId) throws SQLException {
        String sql = "{CALL retrieve_file(?, ?, ?, ?)}";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setLong(1, fileId);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.BLOB);
            stmt.execute();
            String fileName = stmt.getString(2);
            String fileType = stmt.getString(3);
            Blob fileDataBlob = stmt.getBlob(4);
            InputStream fileData = fileDataBlob.getBinaryStream();
            return new File(fileId, fileName, fileType, fileData);
        }
    }
}

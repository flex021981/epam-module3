package com.epam.module3;

import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    void execute(FileService fileService) throws SQLException, IOException;
}

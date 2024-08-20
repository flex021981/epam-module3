package com.epam.module3;

import java.io.InputStream;

public record File(
        long id,
        String fileName,
        String fileType,
        InputStream fileData
) {
}

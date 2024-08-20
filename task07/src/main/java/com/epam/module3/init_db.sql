CREATE DATABASE IF NOT EXISTS file_share_db;

USE file_share_db;

CREATE TABLE IF NOT EXISTS files (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     file_name VARCHAR(255) NOT NULL,
                                     file_type VARCHAR(50) NOT NULL,
                                     file_data LONGBLOB NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     expiration_at TIMESTAMP NULL
);

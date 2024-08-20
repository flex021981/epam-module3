CREATE PROCEDURE save_file(
    IN p_file_name VARCHAR(255),
    IN p_file_type VARCHAR(50),
    IN p_file_data LONGBLOB,
    IN p_expiration_at TIMESTAMP
)
BEGIN
    INSERT INTO files (file_name, file_type, file_data, created_at, expiration_at)
    VALUES (p_file_name, p_file_type, p_file_data, NOW(), p_expiration_at);
END;

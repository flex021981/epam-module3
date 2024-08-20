CREATE PROCEDURE retrieve_file(
    IN p_file_id BIGINT,
    OUT p_file_name VARCHAR(255),
    OUT p_file_type VARCHAR(50),
    OUT p_file_data LONGBLOB
)
BEGIN
    SELECT file_name, file_type, file_data
    INTO p_file_name, p_file_type, p_file_data
    FROM files
    WHERE id = p_file_id;
END;

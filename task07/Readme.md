## Schema Diagram

To support file storage and retrieval, you'll need a schema with at least one table to store the file metadata and binary data.

### Table: `files`

| Column       | Data Type    | Description                                |
|--------------|--------------|--------------------------------------------|
| `id`         | `BIGINT`     | Primary Key, auto-increment                |
| `file_name`  | `VARCHAR(255)`| Original name of the file                  |
| `file_type`  | `VARCHAR(50)` | MIME type of the file                      |
| `file_data`  | `LONGBLOB`   | Binary data of the file                    |
| `created_at` | `TIMESTAMP`  | Timestamp of when the file was uploaded    |
| `expiration_at` | `TIMESTAMP` | Optional timestamp for file expiration  |


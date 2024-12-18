CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    external_id VARCHAR(255) UNIQUE NOT NULL,
    total_value DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

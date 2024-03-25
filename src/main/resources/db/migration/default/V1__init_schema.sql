CREATE TABLE IF NOT EXISTS USERS
(
    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    username                VARCHAR(36) NOT NULL UNIQUE,
    `password`                VARCHAR(255) NOT NULL,
    email                   VARCHAR(50) NOT NULL UNIQUE,
    firstName               VARCHAR(36) NOT NULL,
    lastName                VARCHAR(36),
    phoneNumber             VARCHAR(20),
    isActive                BOOLEAN NOT NULL,
    dateAdded               TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dateUpdated             TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS TENANTS
(
    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    schemaName              VARCHAR(36) NOT NULL UNIQUE
);

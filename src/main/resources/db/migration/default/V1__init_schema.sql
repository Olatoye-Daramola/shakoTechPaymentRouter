--CREATE TABLE IF NOT EXISTS USERS
--(
----    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
--    id                      BIGSERIAL PRIMARY KEY,
--    username                VARCHAR(36) NOT NULL UNIQUE,
--    password                VARCHAR(255) NOT NULL,
--    email                   VARCHAR(50) NOT NULL UNIQUE,
--    firstName               VARCHAR(36) NOT NULL,
--    lastName                VARCHAR(36),
--    phoneNumber             VARCHAR(20),
--    isActive                BOOLEAN NOT NULL,
--    dateAdded               TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    dateUpdated             TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
--);

CREATE TABLE IF NOT EXISTS users
(
    id                     BIGSERIAL PRIMARY KEY,
    username               VARCHAR(36) NOT NULL UNIQUE,
    password               VARCHAR(255) NOT NULL,
    email                  VARCHAR(50) NOT NULL UNIQUE,
    firstName              VARCHAR(36) NOT NULL,
    lastName               VARCHAR(36),
    phoneNumber            VARCHAR(20),
    isActive               BOOLEAN NOT NULL,
    dateAdded              TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dateUpdated            TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the trigger function for updating the timestamp
CREATE OR REPLACE FUNCTION update_timestamp()
RETURNS TRIGGER AS $$
BEGIN
    NEW.dateUpdated = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger to use the function
CREATE TRIGGER set_timestamp
BEFORE UPDATE ON users
FOR EACH ROW
EXECUTE FUNCTION update_timestamp();

CREATE TABLE IF NOT EXISTS TENANTS
(
--    id                      BIGINT PRIMARY KEY AUTO_INCREMENT,
    id                      BIGSERIAL PRIMARY KEY,
    schemaName              VARCHAR(36) NOT NULL UNIQUE
);

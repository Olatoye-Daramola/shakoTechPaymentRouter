CREATE TABLE IF NOT EXISTS TRANSACTIONS
(
    id                              BIGINT PRIMARY KEY AUTO_INCREMENT,
    country                         VARCHAR(36) NOT NULL,
    referenceNumber                 VARCHAR(36) NOT NULL UNIQUE,
    sessionId                       VARCHAR(255) NOT NULL,
    accountNumber                   VARCHAR(50) NOT NULL UNIQUE,
    transactionAmount               DECIMAL(19, 2) NOT NULL,
    vatAmount                       DECIMAL(19, 2) NOT NULL,
    feeAmount                       DECIMAL(19, 2) NOT NULL,
    settledAmount                   DECIMAL(19, 2) NOT NULL,
    settlementId                    VARCHAR(36),
    sourceAccountNumber             VARCHAR(20),
    sourceAccountName               VARCHAR(50),
    sourceBankCode                  VARCHAR(20),
    transactionRemark               VARCHAR(100),
    transactionDate                 TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status                          VARCHAR(10)
);
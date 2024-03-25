package com.payaza.shakorouter.model.constant;

import lombok.Getter;

@Getter
public enum TransactionStatus {

    INITIATED("Initiated"),
    SUCCESSFUL("Successful"),
    FAILED("Failed");

    private final String status;

    TransactionStatus(String status) {
        this.status = status;
    }
}


package com.payaza.shakorouter.model.constant;

import lombok.Getter;

@Getter
public enum ApiResponseStatus {
    SUCCESSFUL("successful"),
    FAILED("failed");

    private final String status;

    ApiResponseStatus(String status) {
        this.status = status;
    }
}

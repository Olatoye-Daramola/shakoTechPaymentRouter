package com.payaza.shakorouter.util.exception;

public class TenantNotFoundException extends RuntimeException {

    public TenantNotFoundException(String message) {
        super(message);
    }

    public TenantNotFoundException(long tenantId) {
        this(String.format("Tenant with id => %d not found", tenantId));
    }
}

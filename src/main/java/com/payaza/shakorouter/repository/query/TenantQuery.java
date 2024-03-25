package com.payaza.shakorouter.repository.query;

public final class TenantQuery {

    private TenantQuery() {
    }

    public static final String FIND_BY_ID = "SELECT t FROM Tenant t WHERE t.id = :tenantId";

    public static final String FIND_BY_SCHEMA = "SELECT t FROM Tenant t WHERE t.schemaName = :tenantSchema";
}

package com.payaza.shakorouter.config.multitenant;

import static com.payaza.shakorouter.util.CustomLogger.logInfo;

public class TenantContext {

    private TenantContext() {}

    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static void setTenantId(String tenantId) {
        currentTenant.set(tenantId);
        logInfo("TenantContext.setTenantId", "Successfully set current tenant to => " + tenantId);
    }

    public static String getTenantId() {
        return currentTenant.get();
    }

    public static void clear(){
        currentTenant.remove();
    }
}

package com.payaza.shakorouter.service.tenant;

import com.payaza.shakorouter.model.dto.ApiResponse;

public interface TenantService {

    ApiResponse createTenant(String country);
    ApiResponse readAllTenants();
}

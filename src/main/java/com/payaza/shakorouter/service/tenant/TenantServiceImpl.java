package com.payaza.shakorouter.service.tenant;

import com.payaza.shakorouter.config.multitenant.TenantDbConfig;
import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.model.entity.Tenant;
import com.payaza.shakorouter.repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantDbConfig tenantDbConfig;

    public TenantServiceImpl(TenantRepository tenantRepository, TenantDbConfig tenantDbConfig) {
        this.tenantRepository = tenantRepository;
        this.tenantDbConfig = tenantDbConfig;
    }

    @Override
    public ApiResponse createTenant(String country) {
        tenantRepository.findByTenantSchema(country)
                .orElseGet(() -> {
                    Tenant tenant = new Tenant();
                    tenant.setSchemaName(country);
                    Tenant savedTenant = tenantRepository.save(tenant);
                    tenantDbConfig.initDatabase(country);
                    return savedTenant;
                });
        return new ApiResponse();
    }

    @Override
    public ApiResponse readAllTenants() {
        List<Tenant> tenants = tenantRepository.findAll();
        ApiResponse response = new ApiResponse();
        response.setResponseData(tenants);
        return response;
    }
}

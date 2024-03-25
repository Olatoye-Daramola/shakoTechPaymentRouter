package com.payaza.shakorouter.controller;

import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.service.tenant.TenantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.payaza.shakorouter.util.CustomLogger.logRequest;
import static com.payaza.shakorouter.util.CustomLogger.logResponse;

@RestController
@RequestMapping("/api/v1/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/create/{country}")
    public ResponseEntity<ApiResponse> createTenant(@PathVariable("country") String request) {
        logRequest("TenantController.createTenant", request);
        ApiResponse response = tenantService.createTenant(request);
        logResponse("TenantController.createTenant", response.toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read")
    public ResponseEntity<ApiResponse> readAllTenants() {
        ApiResponse response = tenantService.readAllTenants();
        logResponse("TenantController.readAllTenants", response.toString());
        return ResponseEntity.ok(response);
    }
}

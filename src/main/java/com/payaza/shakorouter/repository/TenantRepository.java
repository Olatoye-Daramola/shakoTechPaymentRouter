package com.payaza.shakorouter.repository;

import com.payaza.shakorouter.model.entity.Tenant;
import com.payaza.shakorouter.repository.query.TenantQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query(TenantQuery.FIND_BY_ID)
    Optional<Tenant> findByTenantId(@Param("tenantId") long tenantId);

    @Query(TenantQuery.FIND_BY_SCHEMA)
    Optional<Tenant> findByTenantSchema(@Param("tenantSchema") String tenantSchema);
}

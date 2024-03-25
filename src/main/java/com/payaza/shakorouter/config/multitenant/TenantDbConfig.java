package com.payaza.shakorouter.config.multitenant;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TenantDbConfig {

    private final DataSource dataSource;

    public TenantDbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void initDatabase(String schema) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/tenants")
                .dataSource(dataSource)
                .schemas(schema)
                .load();
        flyway.migrate();
    }
}

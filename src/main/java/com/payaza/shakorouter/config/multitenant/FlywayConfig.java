package com.payaza.shakorouter.config.multitenant;

import com.payaza.shakorouter.repository.TenantRepository;
import com.payaza.shakorouter.repository.UserRepository;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    private final TenantDbConfig tenantDbConfig;

    public FlywayConfig(TenantDbConfig tenantDbConfig) {
        this.tenantDbConfig = tenantDbConfig;
    }

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/default")
                .dataSource(dataSource)
                .schemas(TenantIdentifierResolver.DEFAULT_TENANT)
                .load();
        flyway.migrate();
        return flyway;
    }

    @Bean
    CommandLineRunner commandLineRunner(TenantRepository repository) {
        return args -> {
            repository.findAll().forEach(tenant -> {
                String schema = tenant.getSchemaName();
                tenantDbConfig.initDatabase(schema);
            });
        };
    }
}

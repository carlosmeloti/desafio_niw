package com.example.desafio_niw.configs;

import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FlywayConfig {
    @Bean
    public ApplicationRunner runMigrations(Flyway flyway) {
        return args -> {
            flyway.clean();
            flyway.migrate();
        };
    }

}

package com.solutionsresource.servicepoint.core.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TestResourceConfig {

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        // dataSource.setJdbcUrl("jdbc:postgresql://localhost/awesome");
        dataSource.setJdbcUrl("jdbc:h2:./servicepoint_data/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        //dataSource.setDriverClass("org.postgresql.Driver");
        dataSource.setDriverClass("org.h2.jdbcx.JdbcDataSource");
        return dataSource;
    }

}

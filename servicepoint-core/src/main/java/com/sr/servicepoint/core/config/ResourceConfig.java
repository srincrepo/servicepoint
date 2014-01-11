package com.sr.servicepoint.core.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ResourceConfig {

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        //dataSource.setJdbcUrl("jdbc:postgresql://localhost/awesome");
        dataSource.setJdbcUrl("jdbc:h2:./servicepoint_data/servicepoint;MODE=PostgreSQL;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;LOCK_TIMEOUT=10000");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");
        //dataSource.setDriverClass("org.postgresql.Driver");
        dataSource.setDriverClass("org.h2.jdbcx.JdbcDataSource");
        return dataSource;
    }

}

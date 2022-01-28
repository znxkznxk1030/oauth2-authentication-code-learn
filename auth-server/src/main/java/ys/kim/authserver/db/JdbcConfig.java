package ys.kim.authserver.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    final JdbcProperties jdbcProperties;

    public JdbcConfig(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(jdbcProperties.getDriverClassName());
        dataSourceBuilder.url(jdbcProperties.getUrl());
        dataSourceBuilder.username(jdbcProperties.getUsername());
        dataSourceBuilder.password(jdbcProperties.getPassword());
        return dataSourceBuilder.build();
    }
}

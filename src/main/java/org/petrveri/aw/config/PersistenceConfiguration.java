package org.petrveri.aw.config;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    private final static Logger log = LoggerFactory.getLogger(PersistenceConfiguration.class);

    @Value("${connectionString}")
    private String connectionString;
    @Value("${sqlUserName}")
    private String sqlUserName;
    @Value("${sqlPassword}")
    private String sqlPassword;

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        log.info("connectionString:\t{}", connectionString);
        log.info("sqlUserName:\t{}", sqlUserName);
        log.info("sqlPassword:\t{}", sqlPassword);
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if (connectionString != null) {
            dataSource.setUrl(connectionString);
        } else {
            dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
        }
        if (sqlUserName != null) {
            dataSource.setUsername(sqlUserName);
        } else {
            dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("spring.datasource.username")));
        }
        if (sqlPassword != null) {
            dataSource.setPassword(sqlPassword);
        } else {
            dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("spring.datasource.password")));
        }
        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("spring.datasource.driverClassName")));
        return dataSource;
    }
}

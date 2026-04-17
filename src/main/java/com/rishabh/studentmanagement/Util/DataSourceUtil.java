package com.rishabh.studentmanagement.Util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;

public class DataSourceUtil {

    private static final HikariDataSource DATA_SOURCE = createDataSource();

    private static HikariDataSource createDataSource() {
        Properties properties = loadProperties();
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(requireProperty(properties, "db.url"));
        config.setUsername(requireProperty(properties, "db.username"));
        config.setPassword(requireProperty(properties, "db.password"));
        config.setDriverClassName(properties.getProperty("db.driver", "com.mysql.cj.jdbc.Driver"));

        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.pool.maxSize", "10")));
        config.setMinimumIdle(Integer.parseInt(properties.getProperty("db.pool.minIdle", "2")));
        config.setIdleTimeout(Long.parseLong(properties.getProperty("db.pool.idleTimeoutMs", "30000")));
        config.setConnectionTimeout(Long.parseLong(properties.getProperty("db.pool.connectionTimeoutMs", "20000")));

        return new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = DataSourceUtil.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("application.properties not found in classpath");
            }
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load application.properties", e);
        }
    }

    private static String requireProperty(Properties properties, String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required property: " + key);
        }
        return value;
    }
}

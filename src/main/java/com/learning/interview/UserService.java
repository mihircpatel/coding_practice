package com.learning.interview;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    User getUser(String id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresq.Driver");
        String url = "jdbc:postgresql://REPLACEME/DATABASE";
        Connection conn = DriverManager.getConnection(url,"username","password");

        String selectSql = "SELECT * FROM employees";
        List<User> users = new ArrayList<>();
        try(Statement stmt = conn.createStatement()) {
            try(ResultSet resultSet = stmt.executeQuery(selectSql)) {
                while(resultSet.next()) {
                    User u = new User();
                    u.setId(resultSet.getString("id"));
                    u.setName(resultSet.getString("name"));
                    users.add(u);
                }
            }
        }

        for (User u: users) {
            if(u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    @Data
    class User {
        String id;
        String name;
    }
}

class OptimizedUserService {
    /**
     * Fetch employee specific to id instead of all employee records and return it.
     */
    private static final String SELECT_SQL = "SELECT * FROM employees WHERE id = ?";
    private static final String URL = "jdbc:postgresql://REPLACEME/DATABASE";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private final DataSource dataSource;

    public OptimizedUserService() {
        /**
         *  Use Connection Pooling: Creating a new connection for every database operation can be expensive.
         *  We can use connection pooling to reuse connections and avoid the overhead of creating new ones.
         */
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        this.dataSource = new HikariDataSource(config);
    }

    User getUser(String id) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             /**
              * Use PreparedStatement: Instead of using a Statement object, we can use a PreparedStatement object,
              * which is precompiled and can accept parameters.
              * This will improve performance by reducing the number of SQL parsing operations.
              */
             PreparedStatement stmt = conn.prepareStatement(SELECT_SQL)) {
            stmt.setString(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    User u = new User();
                    u.setId(resultSet.getString("id"));
                    u.setName(resultSet.getString("name"));
                    return u;
                }
            }
        }
        return null;
    }

    @Data
    class User {
        String id;
        String name;
    }
}


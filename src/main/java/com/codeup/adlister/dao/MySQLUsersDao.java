package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractUser(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    private List<User> createAdsFromResults(ResultSet rs) throws SQLException {
        List<User> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractUser(rs));
        }
        return ads;
    }

    @Override
    public Long insert(User user) {
        try{
            String sql = "INSERT INTO users(username,password,email) VALUES (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getEmail());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        }catch(SQLException e){
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}

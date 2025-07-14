package org.lab1JM.dao;

import org.lab1JM.model.User;
import org.lab1JM.misc.connectionSQL;

import java.sql.*;

public class UserDAO {

    public boolean insertUser(User user) {
        String sql = "INSERT INTO JM_REG_USER (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
        try (Connection conn = connectionSQL.getConnection()) {
            if (conn == null) return false;

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            int rows = stmt.executeUpdate();
            if (rows == 0) return false;

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUserID(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM JM_REG_USER WHERE USER_ID = ?";
        try (Connection conn = connectionSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("USER_ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE JM_REG_USER SET NAME = ?, EMAIL = ?, PASSWORD = ? WHERE USER_ID = ?";
        try (Connection conn = connectionSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getUserID());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM JM_REG_USER WHERE USER_ID = ?";
        try (Connection conn = connectionSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

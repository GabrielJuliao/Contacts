package com.gabrieljuliao.Contacts.dao;

import com.gabrieljuliao.Contacts.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final Connection connection;
    private String query;
    private PreparedStatement statement;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void createUser(User user) {
        query = "insert into users (email, password, firstName, lastName) VALUES (?,?,?,?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUser(String id) {
        query = "delete from users where user_id=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getUser(String emailX) {
        query = "select * from users where email=?";
        User user = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, emailX);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getString("user_id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        query = "update users set  firstName = ?, lastName = ?, email = ? where user_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

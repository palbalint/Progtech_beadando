package com.models.Models;

import com.models.db_models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public Users login(String username, String password) throws SQLException, ClassNotFoundException {
        try{
            Connection conn = DbConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT users_id, username, password, email, first_name, last_name, address FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(!result.isBeforeFirst()){
                return null;
            }
            result.next();
            Users user = new Users();
            user.setId(Integer.parseInt(result.getString("users_id")));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setEmail(result.getString("email"));
            user.setFirst_name(result.getString("first_name"));
            user.setLast_name(result.getString("last_name"));
            user.setAddress(result.getString("address"));
            return user;
        }catch (SQLException e){
            throw e;
        }catch (ClassNotFoundException e){
            return null;
        }
    }
}

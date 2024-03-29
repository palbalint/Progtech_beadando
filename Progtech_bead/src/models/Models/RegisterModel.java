package com.models.Models;

import com.models.db_models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel {

    /**
     * A megadott paraméterek alapján létrehoz egy új felhasználót az adatbázisban
     * @param user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void register(Users user) throws SQLException, ClassNotFoundException {
        try {
            Connection conn = DbConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement("insert into users (username, password, email, first_name, last_name, address) values (?,?,?,?,?,?)");


            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirst_name());
            statement.setString(5, user.getLast_name());
            statement.setString(6, user.getAddress());

            statement.execute();


        } catch (SQLException e){
            throw e;
        } catch (ClassNotFoundException e){

        }
    }
}

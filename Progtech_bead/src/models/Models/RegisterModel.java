package models.models.models;

import models.models.db_models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterModel {
    public void register(Users user) throws SQLException, ClassNotFoundException {
        try {
            Connection conn = DbConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement("insert into users (username, password, email, first_name, last_name, address) values (?,?,?,?,?,?)");

            if(user.getUsername().length() < 8 || user.getAddress().length() < 15 || user.getEmail().length() < 5 || user.getFirst_name().length() < 2 || user.getLast_name().length() < 2 ||user.getPassword().length() < 8){
                throw new SQLException();
            }

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

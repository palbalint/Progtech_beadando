package com.models.Models;

import com.models.db_models.Cars;
import com.models.db_models.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RentalModel {

    public RentalModel(){
        this.cars = new ArrayList<>();
    }

    private Users loggedIn;
    public ArrayList<Cars> cars;

    public Users getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Users loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void getAllCars() throws SQLException, ClassNotFoundException {
        try{
            Connection conn = DbConnector.getConnection();
            Statement statement = conn.createStatement();
            String stmnt = "SELECT * from cars";
            ResultSet result = statement.executeQuery(stmnt);

            while(result.next()){
                Cars car = new Cars();
                car.setId(Integer.parseInt(result.getString("cars_id")));
                car.setManufacturer(result.getString("manufacturer"));
                car.setModel(result.getString("model"));
                car.setPrice_per_day(Integer.parseInt(result.getString("price_per_day")));

                cars.add(car);
            }
        }catch (SQLException e){
            throw e;
        }catch (ClassNotFoundException e){

        }
    }
}

package com.models.Models;

import com.models.db_models.Cars;
import com.models.db_models.Rental;
import com.models.db_models.Users;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RentalModel {

    public RentalModel(){
        this.cars = new ArrayList<>();
        this.rental = new Rental();
    }

    private Users loggedIn;
    public ArrayList<Cars> cars;
    public ArrayList<Cars> rentedCars;
    public Rental rental;
    public int price = 0;

    public Users getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Users loggedIn) {
        this.loggedIn = loggedIn;
    }

    public int getPrice(){
        return price;
    }

    public long rentedInterval(){
        Date from = rental.getRented_from();
        Date to = rental.getRented_to();

        long interval = (to.getTime() - from.getTime()) / 86400000;
        return Math.abs(interval);
    }

    public void makeRentalValid(int id){
        Cars car = cars.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        rentedCars.add(car);
        price += car.getPrice_per_day() * rentedInterval();
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

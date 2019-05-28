package com.models.db_models;

import java.sql.Date;

public class Rental {
    private int id;
    private Date rented_from;
    private Date rented_to;
    private int cars_id;
    private int users_id;
    private int payment_id;
    private boolean status;

    private Cars car;
    private Payment payment;
    private Users user;

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRented_from() {
        return rented_from;
    }

    public void setRented_from(Date rented_from) {
        this.rented_from = rented_from;
    }

    public Date getRented_to() {
        return rented_to;
    }

    public void setRented_to(Date rented_to) {
        this.rented_to = rented_to;
    }

    public int getCars_id() {
        return cars_id;
    }

    public void setCars_id(int cars_id) {
        this.cars_id = cars_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

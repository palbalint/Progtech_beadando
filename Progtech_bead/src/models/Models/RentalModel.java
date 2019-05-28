package com.models.Models;

import com.models.db_models.Users;

public class RentalModel {

    private int price = 0;
    private Users loggedIn;

    public Users getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Users loggedIn) {
        this.loggedIn = loggedIn;
    }

    public int getPrice() {
        return price;
    }
}

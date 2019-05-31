package com.state;

public class Rented extends RentalState {
    @Override
    public void RentalStateChange(RentalS rental) {
        rental.setState(new NotRented());
    }

    @Override
    public String getStateMessage() {
        return "This car is rented.";
    }
}

package com.state;

public class NotRented extends RentalState {
    @Override
    public void RentalStateChange(RentalS rental) {
        rental.setState(new Rented());
    }

    @Override
    public String getStateMessage() {
        return "This car is not rented yet.";
    }
}

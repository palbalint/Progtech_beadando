package com.state;

public abstract class RentalState {
    public abstract void RentalStateChange(RentalS rental);
    public abstract String getStateMessage();
}

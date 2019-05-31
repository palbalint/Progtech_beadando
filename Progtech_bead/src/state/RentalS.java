package com.state;

public class RentalS {
    private RentalState state;
    public RentalS(){
        this.state = new NotRented();
    }
    public void setState(RentalState state){
        this.state = state;
    }

    public RentalState getState(){
        return this.state;
    }

    public String getStateMessage(){
        return this.state.getStateMessage();
    }
    public void stateChange(){
        state.RentalStateChange(this);
    }
}

package com.classes;

import com.Interfaces.IPaymentInfo;
import com.models.db_models.Users;

public class CashInfo implements IPaymentInfo {
    @Override
    public String info() {
        return "cash";
    }

    private Users user;

    public void setUser(Users user) {
        this.user = user;
    }

    public String getName() throws NullPointerException{
        if(user.getFirst_name() == null || user.getLast_name() == null){
            throw new NullPointerException();
        }
        return user.getFirst_name() + " " + user.getLast_name();
    }
}

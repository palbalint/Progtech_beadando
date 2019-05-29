package com.classes;

import com.Interfaces.IPaymentInfo;
import com.models.db_models.Users;

public class BankCardInfo implements IPaymentInfo {
    @Override
    public String info() {
        return "BANK CARD";
    }

    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Biztosítja, hogy csak valódi bankkártyát fogadjunk el
     * @param cardNumber A bankkártya száma
     * @throws IllegalArgumentException
     */
    public void setCardNumber(String cardNumber) throws IllegalArgumentException {
        if(cardNumber.matches(".*[a-zA-Z]*.")){
            throw new IllegalArgumentException("Card number can only contain numbers!!");
        }
        this.cardNumber = cardNumber;
    }

    private Users user;

    public void setUser(Users user){
        this.user = user;
    }

    public String getName(){
        return user.getFirst_name() + " " + user.getLast_name();
    }
}

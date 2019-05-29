package com.startegy;

import com.Exceptions.InvalidPaymentException;
import com.Interfaces.IPaymentInfo;
import com.classes.BankCardInfo;

public class BankCardPayment extends PaymentStrategy {
    /**
     * A bankkártyás fizetés metódusa
     * @param info információ a felhasználóról
     * @return a fizetés sikerességét
     * @throws InvalidPaymentException
     */
    @Override
    public String Pay(IPaymentInfo info) throws InvalidPaymentException {
        BankCardInfo information = (BankCardInfo) info;
        if(validation(information)){
            return "Succesful Rental by: " + information.getName();
        }
        else
            throw new InvalidPaymentException("Unsuccessful rental.");
    }

    /**
     * A bankkártya validációja
     * @param information A validáció sikeressége
     * @return
     */
    public boolean validation(BankCardInfo information){
        if(information.getCardNumber().length() == 16 )
            return true;
        else return false;
    }
}

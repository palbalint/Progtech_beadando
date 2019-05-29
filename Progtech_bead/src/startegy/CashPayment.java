package com.startegy;

import com.Exceptions.InvalidPaymentException;
import com.Interfaces.IPaymentInfo;
import com.classes.CashInfo;

public class CashPayment extends PaymentStrategy {
    /**
     * A készpénzes fizetés metódusa
     * @param info információ a felhasználóról
     * @return a fizetés sikerességét
     * @throws InvalidPaymentException
     */
    @Override
    public String Pay(IPaymentInfo info) throws InvalidPaymentException {
        CashInfo information = (CashInfo)info;

        try{
            return "Rented by " + information.getName();
        }
        catch (NullPointerException e){
            throw new InvalidPaymentException("Rental is not possible");
        }
    }
}

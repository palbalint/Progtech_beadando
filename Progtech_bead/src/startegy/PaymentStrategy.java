package com.startegy;

import com.Exceptions.InvalidPaymentException;
import com.Interfaces.IPaymentInfo;

public abstract class PaymentStrategy {
    public abstract String Pay(IPaymentInfo info) throws InvalidPaymentException;
}

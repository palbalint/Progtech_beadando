package com.tests;

import com.classes.CashInfo;
import com.Exceptions.InvalidPaymentException;
import com.startegy.CashPayment;
import com.models.db_models.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashPaymentTest {
    @Test
    void payException(){
        CashPayment payment = new CashPayment();
        CashInfo info = new CashInfo();
        Users user = new Users();
        info.setUser(user);
        try{
            payment.Pay(info);
            assertTrue(false);
        }catch (InvalidPaymentException e){
            assertTrue(true);
        }
    }

    @Test
    void payValid(){
        CashPayment payment = new CashPayment();
        CashInfo info = new CashInfo();
        Users user = new Users();
        user.setAddress("lakcimvaros utca hazszam");
        user.setLast_name("utonev");
        user.setFirst_name("csaladnev");
        info.setUser(user);
        try{
            payment.Pay(info);
            assertTrue(true);
        }catch(InvalidPaymentException e){
            assertTrue(false);
        }
    }
}

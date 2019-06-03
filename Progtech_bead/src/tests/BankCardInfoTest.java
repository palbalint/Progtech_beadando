package com.tests;

import com.classes.BankCardInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankCardInfoTest {
    @Test
    void setCardNumberException(){
        BankCardInfo info = new BankCardInfo();
        try{
            info.setCardNumber("asd0123456789");
            assertTrue(false);
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    void setCardNumberValid(){
        BankCardInfo info = new BankCardInfo();
        try{
            info.setCardNumber("1234567891234567");
            assertTrue(true);
        }catch(IllegalArgumentException e){
            assertTrue(false);
        }
    }
}

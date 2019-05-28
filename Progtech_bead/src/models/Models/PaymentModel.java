package com.models.Models;

import com.models.db_models.Payment;
import com.models.db_models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentModel {

    public Payment getPaymentByName(String name) throws SQLException, ClassNotFoundException {
        try{
            Connection conn = DbConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT payment_id, methdod FROM payment WHERE method = ?");
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if(!result.isBeforeFirst()){
                return null;
            }
            result.next();

            Payment payment = new Payment();
            payment.setId(Integer.parseInt(result.getString("payment_id")));
            payment.setMethod(result.getString("method"));
            return payment;
        } catch (SQLException e){
            throw e;
        } catch (ClassNotFoundException e){

        }
        return null;
    }
}

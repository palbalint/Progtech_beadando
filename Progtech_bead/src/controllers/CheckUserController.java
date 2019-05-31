package com.controllers;

import com.Exceptions.InvalidPaymentException;
import com.Interfaces.IPaymentInfo;
import com.classes.BankCardInfo;
import com.classes.CashInfo;
import com.models.Models.BankCardModel;
import com.models.Models.CheckUserModel;
import com.models.Models.PaymentModel;
import com.models.db_models.Payment;
import com.models.db_models.Users;
import com.startegy.BankCardPayment;
import com.startegy.CashPayment;
import com.startegy.PaymentStrategy;
import com.views.BankCardView;
import com.views.CheckUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Logger;

public class CheckUserController {
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

    private CheckUserModel model;
    private CheckUserView view;
    private CheckUserController controller;
    private RentalController rentController;
    private PaymentModel payModel;
    PaymentStrategy strategy;
    IPaymentInfo info;

    public CheckUserController(CheckUserModel model, CheckUserView view, RentalController rentController) {
        this.model = model;
        this.view = view;
        this.controller = this;
        this.rentController = rentController;
        this.payModel = new PaymentModel();

        Users user = model.getUser();
        this.view.setEmail_TF(user.getEmail());
        this.view.setFirstName_TF(user.getFirst_name());
        this.view.setLastName_TF(user.getLast_name());
        this.view.setAddress_TF(user.getAddress());

        this.view.setBankCard_RBActionListener(new BCSelectedListener());
        this.view.setCash_RBActionListener(new CashSelectedListener());
        this.view.setBtn_nextActionListener(new PayButtonListener());

    }

    /**
     * Beállítja, hogy a nézeten a "next" gomb használható-e vagy sem
     * @param status
     */
    public void setNextButtonStatus(boolean status){
        view.setBtn_nextStatus(status);
    }

    class BCSelectedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BankCardModel model = new BankCardModel();
            BankCardView view = new BankCardView();
            BankCardController bcontroller = new BankCardController(view, model);
            view.setVisible(true);
            info = new BankCardInfo();
            ((BankCardInfo)info).setUser(model.getUser());
            strategy = new BankCardPayment();
            setNextButtonStatus(false);
        }
    }

    class CashSelectedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            info = new CashInfo();
            ((CashInfo)info).setUser(model.getUser());
            strategy = new CashPayment();
            view.setBtn_nextStatus(true);
        }
    }
    class PayButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                view.setStatus_lbl(strategy.Pay(info));
                Users user = rentController.getUser();
                Payment method = payModel.getPaymentByName(info.info());

                //rentController.

            } catch (InvalidPaymentException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}

package com.controllers;

import com.classes.BankCardInfo;
import com.models.Models.BankCardModel;
import com.models.Models.RentalModel;
import com.models.db_models.Users;
import com.views.BankCardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankCardController {

    private RentalModel rentMod;
    private BankCardView view;
    private BankCardModel model;
    private CheckUserController chcontroller;

    public BankCardController(BankCardView view, BankCardModel model, CheckUserController chcontroller, RentalModel rentMod) {
        this.view = view;
        this.model = model;
        this.chcontroller = chcontroller;
        this.rentMod = rentMod;

        this.view.setBtn_payActionListener(new PayButtonActionListener());
    }

    class PayButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setBankCardNumber(view.getBankCardNumber());
            model.setUser(rentMod.getLoggedIn());

            try{
                ((BankCardInfo) chcontroller.info).setUser(model.getUser());
                ((BankCardInfo)chcontroller.info).setCardNumber(model.getBankCardNumber());

                chcontroller.setNextButtonStatus(true);
                view.setVisible(false);
            }catch (IllegalArgumentException ex){
                view.setLbl_valid("Your bank card is not valid!");
            }
        }
    }
}

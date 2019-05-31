package com.controllers;

import com.models.Models.BankCardModel;
import com.views.BankCardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankCardController {

    BankCardView view;
    BankCardModel model;

    public BankCardController(BankCardView view, BankCardModel model) {
        this.view = view;
        this.model = model;

        this.view.setBtn_payActionListener(new PayButtonActionListener());
    }

    class PayButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setBankCardNumber(view.getBankCardNumber());
        }
    }
}

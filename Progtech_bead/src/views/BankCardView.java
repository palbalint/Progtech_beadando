package com.views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BankCardView extends JFrame{
    private JButton btn_pay;
    private JPanel mainPanel;
    private JTextField bankCradNumber_TF;
    private JLabel lbl_valid;

    public void setBtn_payActionListener(ActionListener listener) {
        this.btn_pay.addActionListener(listener);
    }

    public String getBankCardNumber(){
        return this.bankCradNumber_TF.getText();
    }

    public void setLbl_valid(String state){
        this.lbl_valid.setText(state);
    }

    public BankCardView(){
        add(mainPanel);
        setTitle("Pay with bank card");
        setResizable(false);
        setSize(600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

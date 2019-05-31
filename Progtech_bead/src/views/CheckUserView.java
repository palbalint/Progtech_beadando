package com.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckUserView extends JFrame{
    private JPanel mainPanel;
    private JTextField email_TF;
    private JTextField firstName_TF;
    private JTextField lastName_TF;
    private JTextField address_TF;
    private JButton btn_next;
    private JRadioButton BankCard_RB;
    private JRadioButton Cash_RB;
    private JLabel status_lbl;
    private ButtonGroup payment;

    public void setBtn_nextActionListener(ActionListener listener){
        this.btn_next.addActionListener(listener);
    }
    public void setBankCard_RBActionListener(ActionListener listener){
        this.BankCard_RB.addActionListener(listener);
    }
    public void setCash_RBActionListener(ActionListener listener){
        this.Cash_RB.addActionListener(listener);
    }
    public void setStatus_lbl(String status){
        this.status_lbl.setText(status);
    }
    public void setBtn_nextStatus(boolean status){
        this.btn_next.setEnabled(status);
    }

    public void setEmail_TF(String email){
        this.email_TF.setText(email);
    }
    public void setFirstName_TF(String firstName){
        this.firstName_TF.setText(firstName);
    }
    public void setLastName_TF(String lastName){
        this.lastName_TF.setText(lastName);
    }
    public void setAddress_TF(String address){
        this.address_TF.setText(address);
    }

    public CheckUserView(){
        add(mainPanel);
        setTitle("Check user");
        setResizable(false);
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.email_TF.setEnabled(false);
        this.firstName_TF.setEnabled(false);
        this.lastName_TF.setEnabled(false);
        this.address_TF.setEnabled(false);
        payment = new ButtonGroup();

        payment.add(BankCard_RB);
        payment.add(Cash_RB);
    }
}

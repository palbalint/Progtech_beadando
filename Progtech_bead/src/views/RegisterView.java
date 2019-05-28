package com.views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JPanel regMain;
    private JTextField username_TF;
    private JPasswordField password_PF;
    private JPasswordField verification_PF;
    private JTextField email_TF;
    private JTextField firstname_TF;
    private JTextField lastname_TF;
    private JTextField address_TF;
    private JButton registerButton;
    private JLabel lbl_res;

    public String getUsername(){
        return this.username_TF.getText();
    }
    public String getVerification(){
        return new String(this.verification_PF.getPassword());
    }
    public String getPassword(){
        return new String(this.password_PF.getPassword());
    }
    public String getEmail(){
        return this.email_TF.getText();
    }
    public String getFirstName(){
        return this.firstname_TF.getText();
    }
    public String getLastName(){
        return this.lastname_TF.getText();
    }
    public String getAddress(){
        return this.address_TF.getText();
    }

    public void setRegisterActionListener(ActionListener listener){
        this.registerButton.addActionListener(listener);
    }
    public void setResult(String result){
        this.lbl_res.setText(result);
    }

    public RegisterView(){
        add(regMain);
        setTitle("Registration");
        setResizable(false);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

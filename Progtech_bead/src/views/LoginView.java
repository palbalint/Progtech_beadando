package com.views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPasswordField password_PF;
    private JTextField username_TF;
    private JButton btn_login;
    private JButton btn_register;
    private JPanel mainPanel;

    public String getUsername(){
        return this.username_TF.getText();
    }
    public String getPassword(){
        return new String(this.password_PF.getPassword());
    }

    public void setLoginActionListener(ActionListener listener){
        this.btn_login.addActionListener(listener);
    }
    public void setRegisterActionListener(ActionListener listener){
        this.btn_register.addActionListener(listener);
    }

    public  LoginView(){
        add(mainPanel);
        setTitle("RentalApp");
        setResizable(false);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void createUIComponents(){

    }
}

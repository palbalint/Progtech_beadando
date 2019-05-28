package com.controllers;

import com.models.Models.LoginModel;
import com.models.Models.RentalModel;
import com.models.db_models.Users;
import com.views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Logger;

public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;

        view.setLoginActionListener(new LoginListener());
        view.setRegisterActionListener(new Registerlistener());

    }

    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            try{
                Users user = model.login(username, password);
                if(user != null){
                    RentalModel rentmod = new RentalModel();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}

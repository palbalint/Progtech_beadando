package com;

import com.controllers.LoginController;
import com.models.Models.LoginModel;
import com.views.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
        view.setVisible(true);
    }
}

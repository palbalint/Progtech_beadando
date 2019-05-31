package com;

import com.controllers.LoginController;
import com.controllers.RentalController;
import com.models.Models.LoginModel;
import com.models.Models.RentalModel;
import com.views.LoginView;
import com.views.RentalView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LoginView view = new LoginView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
        view.setVisible(true);
        /*RentalView view = new RentalView();
        RentalModel model = new RentalModel();
        RentalController controller = new RentalController(model, view);
        view.setVisible(true);*/
    }
}

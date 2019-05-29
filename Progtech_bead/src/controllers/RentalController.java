package com.controllers;

import com.models.Models.RentalModel;
import com.models.db_models.Cars;
import com.views.RentalView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class RentalController {
    private RentalModel model;
    private RentalView view;
    private RentalController controller;

    public RentalController(RentalModel model, RentalView view) throws SQLException, ClassNotFoundException {
        this.model = model;
        this.view = view;
        this.controller = this;
        try{
            model.getAllCars();
        }
        catch(SQLException e){
            view.setRentalLabel("Failed to connect to the database!");
        }catch (ClassNotFoundException e){}

        showTableData(view.getRental_table(), model.cars);

        view.setRentButton(new RentTheCar());
    }

    /**
     * Feltölt egy JTable táblát adatokkal egy listából
     * @param table, a tábla amit fel szeretnénk tölteni
     * @param list, az elemek listája amivel fel szeretnénk tölteni
     */
    public void showTableData(JTable table, ArrayList<Cars> list){
        DefaultTableModel model = (DefaultTableModel)table.getModel();

        int numberOfRows = model.getRowCount();

        for (int i = numberOfRows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for(Cars cars:list){
            model.addRow(new Object[]{cars.getId(), cars.getManufacturer(), cars.getModel(), cars.getPrice_per_day()});
        }

        table.setModel(model);
    }

    class RentTheCar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int col = 0;
            int row = view.getRental_table().getSelectedRow();

            String value = view.getRental_table().getModel().getValueAt(row, col).toString();
            model.makeRentalValid(Integer.parseInt(value));

            model.rental.setStatus(true);

            view.setPriceLabel(model.getPrice());
        }
    }
}

package com.views;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class RentalView extends JFrame{
    private JTable rental_table;
    private JButton btn_rent;
    private JLabel priceOfTheCarLabel;
    private JLabel lbl_price;
    private JLabel lbl_rental;
    private JPanel RentalMain;
    private JButton btn_check;

    public void setPriceLabel(String price){
        this.lbl_price.setText(price);
    }
    public void setRentalLabel(String state){
        this.lbl_rental.setText(state);
    }
    public void setRentButton(ActionListener listener){
        this.btn_rent.addActionListener(listener);
    }
    public void setBtn_checkActionListener(ActionListener listener){
        this.btn_check.addActionListener(listener);
    }

    public JTable getRental_table() {
        return rental_table;
    }

    public void setRental_table(JTable rental_table) {
        this.rental_table = rental_table;
    }

    public RentalView(){
        add(RentalMain);
        setTitle("RentalApp");
        setResizable(false);
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String [] colnames = {"id", "manufacturer", "model", "price per day"};

        DefaultTableModel rental_model = new DefaultTableModel();
        rental_model.setColumnIdentifiers(colnames);
        rental_table.setModel(rental_model);

        rental_table.setRowSelectionAllowed(true);
        this.btn_rent.setEnabled(false);

        rental_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(rental_table.getSelectedRow() > -1){
                    btn_rent.setEnabled(true);
                }
                else{
                    btn_rent.setEnabled(false);
                }
            }
        });
    }
}

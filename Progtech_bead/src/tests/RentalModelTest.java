package com.tests;

import com.models.db_models.Cars;
import com.models.Models.RentalModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentalModelTest {

    @Test
    void getAllCars(){
        RentalModel model = new RentalModel();
        Cars car1 = new Cars();
        Cars car2 = new Cars();
        Cars car3 = new Cars();
        Cars car4 = new Cars();

        model.addCar(car1);
        model.addCar(car2);
        model.addCar(car3);
        model.addCar(car4);

        int expected = 4;
        int actual = model.cars.size();

        assertEquals(expected, actual);
    }
}

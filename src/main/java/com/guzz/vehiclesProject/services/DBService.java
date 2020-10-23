package com.guzz.vehiclesProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guzz.vehiclesProject.domain.Vehicle;
import com.guzz.vehiclesProject.repositories.VehicleRepository;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void instantiateDataBase() throws ParseException {

        Vehicle vehicle1 = new Vehicle(null, "Punto", "Fiat", 2015);
        Vehicle vehicle2 = new Vehicle(null, "EcoSport", "Ford", 2010);

        vehicleRepository.saveAll(Arrays.asList(vehicle1, vehicle2));
    }
}

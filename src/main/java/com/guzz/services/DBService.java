package com.guzz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guzz.domain.Vehicle;
import com.guzz.repositories.VehicleRepository;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void instantiateDataBase() throws ParseException {

        Vehicle vehicle1 = new Vehicle(null, "Punto", "Fiat", 1);
        Vehicle vehicle2 = new Vehicle(null, "EcoSport", "Ford", 2010);

        vehicleRepository.saveAll(Arrays.asList(vehicle1, vehicle2));
    }
}

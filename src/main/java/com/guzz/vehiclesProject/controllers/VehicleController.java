package com.guzz.vehiclesProject.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guzz.vehiclesProject.domain.Vehicle;
import com.guzz.vehiclesProject.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> getVehicles(){
        List<Vehicle> vehicleList = service.getVehicles();
        List<Vehicle> dtoList = vehicleList.stream().map(obj -> new Vehicle()).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Integer id){
    	Vehicle vehicle = service.getVehicle(id);
        return ResponseEntity.ok().body(vehicle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVehicle(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
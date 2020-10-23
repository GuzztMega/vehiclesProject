package com.guzz.vehiclesProject.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guzz.vehiclesProject.domain.Vehicle;
import com.guzz.vehiclesProject.dto.VehicleDTO;
import com.guzz.vehiclesProject.dto.VehicleNewDTO;
import com.guzz.vehiclesProject.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        List<Vehicle> vehicleList = service.getVehicles();
        List<VehicleDTO> dtoList = vehicleList.stream().map(obj -> new VehicleDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Integer id){
    	Vehicle vehicle = service.getVehicle(id);
        return ResponseEntity.ok().body(vehicle);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Vehicle> insertCustomer(@Valid @RequestBody VehicleNewDTO newObj){
    	Vehicle obj = service.fromNewDTO(newObj);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCustomer(@RequestBody VehicleNewDTO newObj, @PathVariable Integer id){
    	Vehicle obj = service.fromNewDTO(newObj);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVehicle(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
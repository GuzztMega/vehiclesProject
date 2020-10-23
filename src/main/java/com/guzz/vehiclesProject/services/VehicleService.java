package com.guzz.vehiclesProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.guzz.vehiclesProject.domain.Vehicle;
import com.guzz.vehiclesProject.dto.VehicleDTO;
import com.guzz.vehiclesProject.dto.VehicleNewDTO;
import com.guzz.vehiclesProject.repositories.VehicleRepository;
import com.guzz.vehiclesProject.services.exceptions.ObjectNotFoundException;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repo;

    public Vehicle insert(Vehicle obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public List<Vehicle> getVehicles(){
        List<Vehicle> vehicles = repo.findAll();
        return vehicles;
    }

    public Vehicle getVehicle(Integer id){
        Optional<Vehicle> vehicle = repo.findById(id);
        return vehicle.orElseThrow(() -> new ObjectNotFoundException(
                "Vehicle not found!" ));
    }

    public Vehicle update(Vehicle obj){
    	Vehicle newObj = getVehicle(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
    	getVehicle(id);
        try{
            repo.deleteById(id);
        } catch (DataIntegrityViolationException dive){
            throw new DataIntegrityViolationException("An erro has occured by deleting this vehicle");
        }
    }

    public void updateData(Vehicle newObj, Vehicle obj){
        newObj.setName(obj.getName());
        newObj.setAssembler(obj.getAssembler());
        newObj.setYear(obj.getYear());
    }
    
    public Vehicle fromNewDTO(VehicleNewDTO objDto){
        return new Vehicle(null, objDto.getName(), objDto.getAssembler(), objDto.getYear());
    }

    public VehicleDTO fromDTO(Vehicle obj){
        return new VehicleDTO(obj);
    }

}

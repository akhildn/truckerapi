package com.anayabu.service;

import com.anayabu.entity.Vehicle;
import com.anayabu.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements VehicleInterface {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void addOrUpdateVehicle(List<com.anayabu.entity.Vehicle> vehicleList){
        for(Vehicle vehicle : vehicleList){
            Optional<com.anayabu.entity.Vehicle> v = vehicleRepository.findById(vehicle.getVin());
            if(v.isPresent()){
                v.get().setMake(vehicle.getMake());
                v.get().setModel(vehicle.getModel());
                v.get().setMaxFuelVolume(vehicle.getMaxFuelVolume());
                v.get().setRedlineRpm(vehicle.getRedlineRpm());
                v.get().setLastServiceDate(vehicle.getLastServiceDate());

                vehicleRepository.save(v.get());
            }else{
                vehicleRepository.save(vehicle);
            }
        }
    }

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }
}

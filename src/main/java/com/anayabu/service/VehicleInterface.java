package com.anayabu.service;

import com.anayabu.entity.Vehicle;

import java.util.List;

public interface VehicleInterface {
    public void addOrUpdateVehicle(List<Vehicle> vehicleList);

    public Iterable<Vehicle> listAllVehicles();
}

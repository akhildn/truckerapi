package com.anayabu.service;

import com.anayabu.entity.VehicleAlert;
import com.anayabu.entity.VehicleStatus;

import java.util.List;

public interface VehicleAlertInterface {

    public void checkForAlert(VehicleStatus vehicleStatus);
    public List<VehicleAlert> getVehicleAlertHistory(String vin);
}

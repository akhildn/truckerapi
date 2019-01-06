package com.anayabu.service;


import com.anayabu.entity.VehicleStatus;
import com.anayabu.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleStatusService implements VehicleStatusInterface {

    private VehicleStatusRepository vehicleStatusRepository;
    private VehicleAlertService vehicleAlertService;

    @Autowired
    public VehicleStatusService(VehicleStatusRepository vehicleStatusRepository, VehicleAlertService vehicleAlertService) {
        this.vehicleStatusRepository = vehicleStatusRepository;
        this.vehicleAlertService = vehicleAlertService;
    }

    @Override
    public void readVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
        vehicleAlertService.checkForAlert(vehicleStatus);
    }
}

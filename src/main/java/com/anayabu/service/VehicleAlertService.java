package com.anayabu.service;

import com.anayabu.entity.Vehicle;
import com.anayabu.entity.VehicleAlert;
import com.anayabu.entity.VehicleStatus;
import com.anayabu.repository.VehicleAlertRepository;
import com.anayabu.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleAlertService implements VehicleAlertInterface {

    private VehicleRepository vehicleRepository;
    private VehicleAlertRepository vehicleAlertRepository;

    @Autowired
    public VehicleAlertService(VehicleRepository vehicleRepository, VehicleAlertRepository vehicleAlertRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleAlertRepository = vehicleAlertRepository;
    }


    @Override
    public void checkForAlert(VehicleStatus vehicleStatus) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleStatus.getVin());
        if(vehicle.isPresent()){
            if(vehicleStatus.getEngineRpm() > vehicle.get().getRedlineRpm() ){
                setVehicleAlert("ENGINE", 1,
                        "Your engine RPM is high, please fix it", vehicle.get() );
            }
            if(vehicleStatus.getFuelVolume() < (0.1 * vehicle.get().getMaxFuelVolume())){
                setVehicleAlert("FUEL", 2,
                        "You need to refuel, fuel level is below 10%", vehicle.get() );
            }
            if(vehicleStatus.getTires().getFrontLeft() < 32 || vehicleStatus.getTires().getFrontLeft() > 36){
                setVehicleAlert("TIRES", 3,
                        "Please fix PSI in your front left tire", vehicle.get() );
            }
            if(vehicleStatus.getTires().getFrontRight() < 32 || vehicleStatus.getTires().getFrontRight() > 36){
                setVehicleAlert("TIRES", 3,
                        "Please fix PSI in your front right tire", vehicle.get() );
            }

            if(vehicleStatus.getTires().getRearLeft() < 32 || vehicleStatus.getTires().getRearLeft() > 36){
                setVehicleAlert("TIRES", 3,
                        "Please fix PSI in your rear left tire", vehicle.get() );
            }

            if(vehicleStatus.getTires().getRearRight() < 32 || vehicleStatus.getTires().getRearRight() > 36){
                setVehicleAlert("TIRES", 3,
                        "Please fix PSI in your rear right tire", vehicle.get() );
            }

            if(vehicleStatus.isCheckEngineLightOn()){
                setVehicleAlert("ENGINE", 1,
                        "Your engine light is on, please go for a service", vehicle.get() );
            }

            if(vehicleStatus.isEngineCoolantLow()){
                setVehicleAlert("ENGINE", 1,
                        "Your engine coolant is low, please go for a service", vehicle.get() );
            }
        }
    }

    @Override
    public List<VehicleAlert> getVehicleAlertHistory(String vin) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vin);
        return vehicle.map(vehicle1 -> (List<VehicleAlert>) vehicleAlertRepository.findAllByVehicle(vehicle1)).orElse(null);

    }

    private void setVehicleAlert(String alertType, int priority, String message, Vehicle vehicle){
        VehicleAlert vehicleAlert = new VehicleAlert();

        vehicleAlert.setAlertType(alertType);
        vehicleAlert.setPriority(priority);
        vehicleAlert.setAlertMessage(message);
        vehicleAlert.setVehicle(vehicle);
        vehicleAlertRepository.save(vehicleAlert);
    }
}

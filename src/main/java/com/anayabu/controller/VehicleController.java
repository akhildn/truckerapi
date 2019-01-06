package com.anayabu.controller;

import com.anayabu.entity.Vehicle;
import com.anayabu.entity.VehicleAlert;
import com.anayabu.entity.VehicleStatus;
import com.anayabu.service.VehicleAlertService;
import com.anayabu.service.VehicleService;
import com.anayabu.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VehicleController {

    private VehicleService vehicleService;
    private VehicleStatusService vehicleStatusService;
    private VehicleAlertService vehicleAlertService;

    @Autowired
    VehicleController(VehicleService vehicleService,
                      VehicleStatusService vehicleStatusService,
                      VehicleAlertService vehicleAlertService){

        this.vehicleService = vehicleService;
        this.vehicleStatusService = vehicleStatusService;
        this.vehicleAlertService = vehicleAlertService;

    }


    @RequestMapping(method = RequestMethod.GET, value = "/vehicles")
    public Iterable<Vehicle> listAllVehicles(){
        return vehicleService.listAllVehicles();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vehicles")
    public void updateVehicles(@RequestBody List<Vehicle> vehicleList){
        vehicleService.addOrUpdateVehicle(vehicleList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/readings")
    public void readVehicleStatus(@RequestBody VehicleStatus vehicleStatus){
        //System.out.println(vehicleStatus);
       vehicleStatusService.readVehicleStatus(vehicleStatus);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/{vin}/alerts")
    public List<VehicleAlert> vehicleAlertHistory(@PathVariable("vin") String vin){
        return vehicleAlertService.getVehicleAlertHistory(vin);

    }

}

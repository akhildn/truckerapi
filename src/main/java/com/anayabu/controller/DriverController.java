package com.anayabu.controller;


import com.anayabu.entity.Driver;
import com.anayabu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/drivers")
    public List<Driver> updateVehicles(){
        return driverService.listAllDrivers();
    }
}

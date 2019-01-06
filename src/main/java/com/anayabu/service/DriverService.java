package com.anayabu.service;

import com.anayabu.entity.Driver;
import com.anayabu.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverService implements DriverInterface{

    private DriverRepository driverRepository;


    @Autowired
    DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> listAllDrivers() {
        List<Driver> driverList = (List<Driver>) driverRepository.findAll();
        return driverList;
    }
}

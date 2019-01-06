package com.anayabu.repository;

import com.anayabu.entity.Vehicle;
import com.anayabu.entity.VehicleAlert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleAlertRepository extends CrudRepository<VehicleAlert, Integer> {
    List<VehicleAlert> findAllByVehicle(Vehicle vehicle);
}

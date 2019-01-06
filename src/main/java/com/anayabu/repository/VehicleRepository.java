package com.anayabu.repository;

import com.anayabu.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
}

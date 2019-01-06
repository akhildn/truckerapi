package com.anayabu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    private String vin;

    private String make;
    private String model;
    private String year;

    private long redlineRpm;
    private double maxFuelVolume;

    private Date lastServiceDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vin")
    @JsonIgnore
    VehicleStatus vehicleStatus;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VehicleAlert> vehicleAlert;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(long redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public List<VehicleAlert> getVehicleAlert() {
        return vehicleAlert;
    }

    public void setVehicleAlert(List<VehicleAlert> vehicleAlert) {
        this.vehicleAlert = vehicleAlert;
    }
}

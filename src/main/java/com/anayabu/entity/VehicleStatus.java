package com.anayabu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VehicleStatus {

    @Id
    private String vin;

    private Double latitude;
    private Double longitude;

    private Double fuelVolume;
    private int speed;
    private int engineHp;
    private int engineRpm;

    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;

    @Embedded
    @JsonProperty(value="tires")
    private Tires tires;

    private Date timestamp;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "VehicleStatus{" +
                "vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", engineRpm=" + engineRpm +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", tires=" + tires +
                ", timestamp=" + timestamp +
                '}';
    }
}

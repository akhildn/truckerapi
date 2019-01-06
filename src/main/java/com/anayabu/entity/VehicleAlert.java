package com.anayabu.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VehicleAlert {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String alertType;
    private String alertMessage;
    private int priority;

    @ManyToOne
    @JoinColumn(name = "vin")
    private Vehicle vehicle;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "VehicleAlert{" +
                "id=" + id +
                ", alertType='" + alertType + '\'' +
                ", alertMessage='" + alertMessage + '\'' +
                ", priority=" + priority +
                ", vehicle=" + vehicle +
                '}';
    }
}

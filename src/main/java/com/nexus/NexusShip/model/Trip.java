package com.nexus.NexusShip.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long Id;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH})
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH})
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "trip" ,
            cascade ={CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Shipment> shipmentList;




    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TripStatus status;


    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    public Trip(){}
    public Trip(Driver driver, Vehicle vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipments) {
        this.shipmentList = shipments;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void addShipment(Shipment shipment) {
        if(shipmentList == null){
            shipmentList = new ArrayList<>();
        }
        shipmentList.add(shipment);
        shipment.setTrip(this);
    }


    @Override
    public String toString() {
        return "Trip{" +
                "Id=" + Id +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                ", shipmentList=" + shipmentList +
                ", status=" + status +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                '}';
    }
}

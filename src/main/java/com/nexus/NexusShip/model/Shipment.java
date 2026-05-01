package com.nexus.NexusShip.model;

import jakarta.persistence.*;

//java.awt.Point is for desktop GUI coordinates (pixels on a screen). It will not work with PostGIS or spatial database queries.
//So we use
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="created_at")
    private LocalDateTime createdAt;

    @Column(name ="arrived_at")
    private LocalDateTime arrivedAt;

    //Many Shipments belong to one sender
    @ManyToOne(cascade ={CascadeType.DETACH , CascadeType.MERGE,
                         CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "sender_id")
    private Sender sender;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,
                          CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @ManyToOne( cascade ={CascadeType.DETACH , CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "trip_id")
    private Trip trip;



    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private double weight;

    @Column(name = "volume")
    private double volume;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @Column(name = "shipment_value")
    private double shipmentValue;

    @Column(name = "shipment_insurance")
    private boolean shippingInsurace;

    @Column(name = "shipemtn_cost")
    private double cost;

    @Column(columnDefinition = "geometry(Point, 4326)" , name = "pickup_location")
    private Point pickUpLocation;

    @Column(columnDefinition = "geometry(Point, 4326)" , name = "destination_location")
    private Point destinationLocation;


    @OneToMany(mappedBy = "shipment" ,
            cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH})
    private List<ShipmentHistory> history;

    public List<ShipmentHistory> getHistory() {
        return history;
    }

    public void setHistory(List<ShipmentHistory> history) {
        this.history = history;
    }

    public void changeStatus(ShipmentHistory action) {
        if(history == null) {
            history = new ArrayList<>();
        }
        this.setStatus(action.getStatus());
        history.add(action);
        action.setShipment(this);
    }



    public Shipment(){}

    public Shipment(LocalDateTime createdAt, LocalDateTime arrivedAt, Receiver receiver, Sender sender, double weight,
                    double volume, ShipmentStatus status, double shipmentValue, boolean shippingInsurace, double cost,
                    Point pickUpLocation, Point destinationLocation , String description) {
        this.createdAt = createdAt;
        this.arrivedAt = arrivedAt;
        this.receiver = receiver;
        this.sender = sender;
        this.weight = weight;
        this.volume = volume;
        this.status = status;
        this.shipmentValue = shipmentValue;
        this.shippingInsurace = shippingInsurace;
        this.cost = cost;
        this.pickUpLocation = pickUpLocation;
        this.destinationLocation = destinationLocation;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(LocalDateTime arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getShipmentValue() {
        return shipmentValue;
    }

    public void setShipmentValue(double shipmentValue) {
        this.shipmentValue = shipmentValue;
    }

    public boolean isShippingInsurace() {
        return shippingInsurace;
    }

    public void setShippingInsurace(boolean shippingInsurace) {
        this.shippingInsurace = shippingInsurace;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Point getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Point pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Point getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Point destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", arrivedAt=" + arrivedAt +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", trip=" + trip +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", status=" + status +
                ", shipmentValue=" + shipmentValue +
                ", shippingInsurace=" + shippingInsurace +
                ", cost=" + cost +
                ", pickUpLocation=" + pickUpLocation +
                ", destinationLocation=" + destinationLocation +
                ", history=" + history +
                '}';
    }
}

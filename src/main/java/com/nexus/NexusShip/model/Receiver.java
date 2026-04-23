package com.nexus.NexusShip.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "receiver")
public class Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "receiver" ,
               cascade ={CascadeType.DETACH , CascadeType.MERGE,
                         CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Shipment> shipmentList;

    public Receiver(){}

    public Receiver(String phoneNumber, Shipment shipment) {
        this.phoneNumber = phoneNumber;
    }


    public List<Shipment> getShipments() {
        return shipmentList;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipmentList = shipments;
    }

    public void addShipment(Shipment shipment){
        if(shipmentList == null){
            shipmentList = new ArrayList<>();
        }
        shipmentList.add(shipment);
        shipment.setReciver(this);

    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


}

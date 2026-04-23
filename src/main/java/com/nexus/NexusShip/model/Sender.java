package com.nexus.NexusShip.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sender")
public class Sender extends User {

    public Sender() {
    }

    public Sender(String firstName, String lastName, Gender gender, String nationalId, String email, String password, String phoneNumber) {
        super(firstName, lastName, gender, nationalId, email, password, phoneNumber);
    }

    @OneToMany(mappedBy = "sender",
                cascade ={CascadeType.DETACH , CascadeType.MERGE,
                          CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Shipment> shipmentList;


    //To make it Bi-directional
    //That's mean we can know the sender from the shipments and know the shipment list from the sender

    public void createShipment(Shipment shipment) {
        if(shipmentList ==null){
            shipmentList = new ArrayList<>();
        }
        shipmentList.add(shipment);
        shipment.setSender(this);
    }


    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipments) {
        this.shipmentList = shipments;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "shipmentList=" + shipmentList +
                '}';
    }
}

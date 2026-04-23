package com.nexus.NexusShip.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class ShipmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //many to one
    //many shipmentHistory record belongs to one shipment
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
    @JoinColumn(name="shipment_id")
    private Shipment shipment;

    @Column(name = "status")
    private ShipmentStatus status;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST ,CascadeType.REFRESH} )
    @JoinColumn(name="who_make_the_change")
    private User whoMakeTheChange;

    @CreationTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "note")
    private String note;

    public ShipmentHistory(){}

    public ShipmentHistory( User whoMakeTheChange , ShipmentStatus status, String note) {
        this.note = note;
        this.updatedAt = LocalDateTime.now();
        this.whoMakeTheChange = whoMakeTheChange;
        this.status = status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getWhoMakeTheChange() {
        return whoMakeTheChange;
    }

    public void setWhoMakeTheChange(User whoMakeTheChange) {
        this.whoMakeTheChange = whoMakeTheChange;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public String toString() {
        return "ShipmentHistory{" +
                "id=" + id +
                ", shipment=" + shipment +
                ", status=" + status +
                ", whoMakeTheChange=" + whoMakeTheChange +
                ", updatedAt=" + updatedAt +
                ", note='" + note + '\'' +
                '}';
    }

}

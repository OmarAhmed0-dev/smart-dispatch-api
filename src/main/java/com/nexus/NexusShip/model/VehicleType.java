package com.nexus.NexusShip.model;

public enum VehicleType {
    VAN(1200 , 15), // (kg , m3)
    TRUCK(2000, 25),
    MOTORCYCLE(10,0.5);

    private final double maxWeight;
    private final double maxVolume;

    VehicleType(double maxWeight ,double maxVolume) {
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }
}

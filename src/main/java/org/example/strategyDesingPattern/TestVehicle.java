package org.example.strategyDesingPattern;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new SUVVehicle();

        Vehicle vehicle1 = new HeavyVehicle();

        vehicle.callStrategy();
        vehicle1.callStrategy();
    }
}

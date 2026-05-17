package org.example.strategyDesingPattern;

public class SportsVehicle extends Vehicle{
    SportsVehicle() {
        super(new FastDriving());
    }
}

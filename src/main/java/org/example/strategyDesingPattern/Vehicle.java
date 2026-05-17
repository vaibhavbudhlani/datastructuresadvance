package org.example.strategyDesingPattern;

public class Vehicle {
    DriveStrategy strategy;

    Vehicle(DriveStrategy strategy){
        this.strategy = strategy;
    }

    public void callStrategy(){
        strategy.drive();
    }


}

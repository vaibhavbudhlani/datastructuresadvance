package org.example.strategyDesingPattern;

public class FastDriving implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving fast!");
    }
}

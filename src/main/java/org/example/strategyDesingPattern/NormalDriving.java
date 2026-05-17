package org.example.strategyDesingPattern;

public class NormalDriving implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving in normal mode.");
    }
}

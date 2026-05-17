package org.example.strategyDesingPattern;

public class HeavyVehicle extends Vehicle{

    HeavyVehicle(){
        super(new NormalDriving());
    }
}

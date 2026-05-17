package org.example.strategyDesingPattern;

public class SUVVehicle extends Vehicle{

    SUVVehicle(){
        super(new FastDriving());
    }
}

package org.example.dp;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Vehicle {
    private String model;
    private String color;

    public Vehicle(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.model.charAt(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return model.equals(vehicle.model) && color.equals(vehicle.color);

    }
}

public class TestHashmap {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle("Model S", "Red");
        Vehicle vehicle2 = new Vehicle("Model 3", "Blue");
        Vehicle vehicle3 = new Vehicle("Model X", "Black");
        Vehicle vehicle4 = new Vehicle("Model Y", "White");
        Vehicle vehicle5 = new Vehicle("Cybertruck", "Silver");
        HashMap<Vehicle, Integer> map = new HashMap<>();
        map.put(vehicle1, 1);
        map.put(vehicle2, 2);
        map.put(vehicle3, 3);
        map.put(vehicle4, 4);
        map.put(vehicle5, 5);
//        System.out.println(vehicle1.hashCode());
//        System.out.println(vehicle2.hashCode());
        List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");
        list.stream().map(str -> str.charAt(2)).forEach(System.out::println);

        //map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

//        HashMap<String, Integer> hm = new HashMap<>();
//        hm.put("A", 1);
//        hm.put("B", 2);
//        hm.put("A", 3);
//
//        hm.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));


    }
}




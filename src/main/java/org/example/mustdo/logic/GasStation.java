package org.example.mustdo.logic;
//Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//Output: 3

// Input: gas = [2,3,4], cost = [3,4,3]
//Output: -1

//Gas Station Problem Statement
//Problem Description
//There are n gas stations along a circular route, where the amount of gas at the i-th station is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the i-th station to its next (i + 1)-th station. You begin the journey with an empty tank at one of the gas stations.
//
//Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
//
//Input Format
//gas[] - An integer array where gas[i] represents the amount of gas available at station i
//cost[] - An integer array where cost[i] represents the cost of gas to travel from station i to station i+1
//Output Format
//Return the starting station's index (0-based) if you can complete the circuit
//Return -1 if it's impossible to complete the circuit
//Constraints
//n == gas.length == cost.length
//1 <= n <= 10^5
//0 <= gas[i], cost[i] <= 10^4
//Examples
//Example 1:
//Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//Output: 3
//Explanation:
//- Start at station 3 (index 3) and fill up with 4 units of gas. Tank = 0 + 4 = 4
//- Travel to station 4. Tank = 4 - 1 + 5 = 8
//- Travel to station 0. Tank = 8 - 2 + 1 = 7
//- Travel to station 1. Tank = 7 - 3 + 2 = 6
//- Travel to station 2. Tank = 6 - 4 + 3 = 5
//- Travel to station 3. Tank = 5 - 5 = 0 (completed the circuit)
//Example 2:
//Input: gas = [2,3,4], cost = [3,4,3]
//Output: -1
//Explanation:
//- You can't start at any station and complete the circuit.
//- Starting from any station, you will run out of gas before completing the circuit.
//Key Insights
//The solution uses a greedy approach:
//
//Total Gas Check: First, if the total gas available is less than the total cost, it's impossible to complete the circuit, so return -1.
//
//Find Starting Point: Use a running balance to track gas surplus/deficit. If at any point the balance becomes negative, it means we cannot start from any previous station (including the current one). So we reset and try starting from the next station.
//
//Uniqueness: The problem guarantees that if a solution exists, it is unique.
//
//Time Complexity
//O(n) - Single pass through the arrays
//Space Complexity
//O(1) - Only using constant extra space
//Related Topics
//Array
//Greedy Algorithm
//Circular Array

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        GasStation station = new GasStation();
        System.out.println(station.giveStation(gas,cost));
    }

    public int giveStation(int[] gas, int[] cost){
        int tgas = 0;
        int tcost = 0;
        int ans = 0;
        for(int i=0;i<gas.length;i++){
            tgas += gas[i];
            tcost += cost[i];
        }

        if(tcost > tgas){
            return -1;
        }

        int temp = 0;
        for(int i=0;i<gas.length;i++){
            temp += (gas[i] - cost[i]);
            if(temp < 0){
                temp = 0;
                ans = i+1;
            }
        }
        return ans;
    }
}

package org.example.mustdo.logic;
//Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//Output: 3

// Input: gas = [2,3,4], cost = [3,4,3]
//Output: -1

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

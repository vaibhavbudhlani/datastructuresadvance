package org.example.mustdo.logic;
//Example 1:
//
//Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//
//Output: 3
//
//Explanation:
//
//The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
//The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
//The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
//Example 2:
//
//Input: target = 10, position = [3], speed = [3]
//
//Output: 1
//
//Explanation:
//
//There is only one car, hence there is only one fleet.
//Example 3:
//
//Input: target = 100, position = [0,2,4], speed = [4,2,1]
//
//Output: 1
//
//Explanation:
//
//The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
//Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        CarFleet obj = new CarFleet();

        System.out.println(obj.carFleet(target,position,speed));
    }
    public int carFleet(int target, int[] pos, int[] speed) {
        int res =0;
        //position = [10,8,0,5,3]
        // speed = [2,4,1,1,3]
        int[] time = new int[target];
        for(int i=0;i<pos.length;i++){
            time[pos[i]] = (target - pos[i]) / speed[i];
        }
        // time[10] =  1;
        // time[8] = 1

        int prev = 0;
        for(int i = target-1;i>=0 ;i--){
            if(prev < time[i]){
                prev = time[i];
                res++;
            }
        }
        return res;
    }
}

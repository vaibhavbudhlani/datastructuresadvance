package org.example;

//Input : arr = {2, 3, 10, 6, 4, 8, 1}
//Output : 8
//Explanation : The maximum difference is between 10 and 2.
//
//Input : arr = {7, 9, 5, 6, 3, 2}
//Output : 2
//Explanation : The maximum difference is between 9 and 7.

//Maximum Difference between Two Elements such that Larger Element Appears after the Smaller Element

public class MaxDifference {
    public static void main(String[] args) {

        int[] a = {2, 3, 10, 6, 4, 8, 1};
        int[] a1 = {5, 4, 3, 2, 1};
        int[] a2 = {2, 3, 10, 6, 4, 8, 1};

        int mindiff = a[1] - a[0];
        int min = a[0];


        for (int i = 1; i < a.length; i++) {
            if (a[i] - min > mindiff) {
                mindiff = a[i] - min;
            }
            if (a[i] < min) {
                min = a[i];
                System.out.println("Min is "+min);
            }
        }

        System.out.println(mindiff);
        System.out.println(maxDiff(a,a.length));


    }


    static int maxDiff (int arr[], int n)
    {
        // Initialize diff, current
        // sum and max sum
        int diff = arr[1] - arr[0];
        int curr_sum = diff;
        int max_sum = curr_sum;

        for(int i = 1; i < n - 1; i++)
        {
            // Calculate current diff
            // 2, 3, 10, 6, 4, 8, 1
            // 1 2 3 4 5
            // currsum 8
            // dif  1
            // maxsum 8
            diff = arr[i + 1] - arr[i];

            // Calculate current sum
            if (curr_sum > 0)
                curr_sum += diff;
            else
                curr_sum = diff;

            // Update max sum, if needed
            if (curr_sum > max_sum)
                max_sum = curr_sum;
        }

        return max_sum;
    }
}

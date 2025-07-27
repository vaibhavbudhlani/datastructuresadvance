import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    // Tail Array is the key
    public static void main(String[] args) {
        int[] a = {3, 4, 2, 8, 10, 78, 6, 1};
        int[] a1 = {3, 10,20,4,6,7};
        int tail[] = new int[a.length];
        tail[0] = a[0];
        int ctr = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > tail[ctr]) {
                tail[++ctr] = a[i];
            } else {
                int index = getIndex(tail, 0, ctr, a[i]);
                tail[index] = a[i];
            }
        }

        System.out.println("Tail array: " + Arrays.toString(tail));

    }

    private static int getIndex(int[] tail, int l, int r, int target) {

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (tail[mid] >= target) {
                r= mid;
            }
            else{
                l= mid +1 ;
            }
        }

        return r;


    }
}

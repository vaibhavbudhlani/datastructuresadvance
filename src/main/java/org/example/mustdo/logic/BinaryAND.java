package org.example.mustdo.logic;

import java.util.*;

public class BinaryAND {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume the newline

        for (int t = 0; t < T; t++) {
            String A = scanner.nextLine(); // Binary string A
            String B = scanner.nextLine(); // Binary string B

            // Convert binary strings to integers
            long a = Long.parseLong(A, 2);
            long b = Long.parseLong(B, 2);

            int iterations = 0;

            // Perform the addition algorithm
            while (b > 0) {
                long u = a ^ b; // XOR operation
                long v = a & b; // AND operation
                a = u;
                b = v << 1; // Multiply v by 2 (left shift)
                iterations++;
            }

            // Output the number of iterations
            System.out.println(iterations);
        }

        scanner.close();
    }
}

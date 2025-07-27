package org.example.mustdo.stack;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] a1 = {5, 10, -5};
        int[] a = {10, 2, -5};
        AsteroidCollision collision = new AsteroidCollision();

        int[] res = collision.asteroidCollision(a);
//        for (int v : res) {
//            System.out.print(v + " ");
//        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int v : asteroids) {
            if (v > 0) {

            } else {
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(v);

                }
            }
            if (st.isEmpty()) return new int[0];
            int[] res = new int[st.size()];
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = st.pop();
            }
            return res;
        }
        return null;

    }
}
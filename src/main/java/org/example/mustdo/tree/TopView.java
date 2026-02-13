package org.example.mustdo.tree;

import java.util.*;

class Pairs {
    Node node;
    int col;

    Pairs(Node node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class TopView {
    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.left.right.right = newNode(5);
        root.left.right.right.right = newNode(6);
        System.out.println("Following are nodes in top view of Binary Tree\n");
        topView(root).forEach(x -> System.out.print(x + " "));
    }


    static Node newNode(int key) {
        Node node = new Node(key);
        node.left = node.right = null;
        node.data = key;
        return node;
    }

    private static List<Integer> topView(Node root) {
        Queue<Pairs> q = new LinkedList<>();
        q.add(new Pairs(root, 0));
        Map<Integer, Integer> tm = new TreeMap<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pairs p = q.poll();

                Node node = p.node;
                int col = p.col;

                if(!tm.containsKey(col)){
                    tm.put(col,node.data);
                }
                if (node.left != null) {
                    q.offer(new Pairs(node.left, col - 1));
                }

                if (node.right != null) {
                    q.offer(new Pairs(node.right, col + 1));
                }


            }
        }
        return new ArrayList<>(tm.values());
    }



}

package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

// This is not BFS Traversal it is level wise traversal of tree

public class BFSTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        //root.right.right.right = new Node(60);


        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            height++;
            int size = q.size();

            for(int i=0;i<size;i++){
                Node curr = q.poll();
                System.out.println(curr != null ? curr.data : 0);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }



            System.out.println();

        }

        System.out.println("Height of the tree is "+height);

    }
}

package org.example.tree;

public class HeightOfTreeUsingDFS {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.right = new Node(60);
        System.out.println(calculateHeight(root));

    }

    private static int calculateHeight(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(calculateHeight(root.left),calculateHeight(root.right))+1;
    }
}

package org.example.mustdo.tree;



class BinaryTree {
    Node root;

    /* If target is present in tree, then prints the ancestors
       and returns true, otherwise returns false. */
    boolean printAncestors(Node node, int target) {
        if(node == null){
            return false;
        }

        if(node.data == target){
            return true;
        }
        if(printAncestors(node.left,target) || printAncestors(node.right,target)){
            System.out.print(node.data + " ");
            return true;
        }
        return false;
    }
}

public class PrintAncestors {


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 1);
    }
}

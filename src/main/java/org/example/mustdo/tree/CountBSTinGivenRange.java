package org.example.mustdo.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CountBSTinGivenRange {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        int l = 5;
        int h = 45;

        System.out.println(getCountUsingRecurrsion(root, l, h));
        System.out.println(getCountUsingQueue(root, l, h));
    }

    static int getCountUsingRecurrsion(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }
        int val = root.data;
        if (val >= l && val <= h) {
            return 1 + getCountUsingRecurrsion(root.left, l, h) + getCountUsingRecurrsion(root.right, l, h);
        }
        else if (val < l) {

            return getCountUsingRecurrsion(root.right, l, h);
        } else {

            return getCountUsingRecurrsion(root.left, l, h);
        }

    }


    static int getCountUsingQueue(Node root,int l, int h){
        Queue<Node> q = new LinkedList();

        if(root == null){
            return 0;
        }
       q.offer(root);
        int ans = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int val = node.data;

            if(val>=l && val<= h){
                ans++;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }

            else if(val < l){
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            else{
                if(node.left != null){
                    q.offer(node.left);
                }
            }

        }
        return ans;
    }



}

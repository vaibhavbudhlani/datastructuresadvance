package org.example.mustdo.tree;
// If not able to ge this solution try maintaining one adjacency list and then use BFS

import java.util.*;

public class AmountOfTimeToBeInfected {
    public static void main(String[] args) {
       Integer[] root = {1,5,3,null,4,10,6,9,2};
       int start = 3;
        TreeNode node = TreeBuilder.buildTree(root);
        AmountOfTimeToBeInfected obj = new AmountOfTimeToBeInfected();
        System.out.println(obj.amountOfTime(node,start));
    }

    int maxtime=0;
    public int amountOfTime(TreeNode root, int start) {
        find(root,start);
        return maxtime;
    }
    private int find(TreeNode root,int start){
        if(root==null) return -1;

        if(root.val==start){
            dfs(root,0);
            return 1;
        }
        int left=find(root.left,start);
        if(left>0){
            dfs(root.right,left+1);
            maxtime=Math.max(maxtime,left);
            return left+1;
        }
        int right = find(root.right, start);
        if (right > 0) {
            dfs(root.left, right+1);
            maxtime = Math.max(maxtime, right);
            return right + 1;
        }
        return -1;

    }
    private void dfs(TreeNode root,int time){
        if(root ==null) return ;

        maxtime=Math.max(maxtime,time);
        dfs(root.left,time+1);
        dfs(root.right,time+1);
    }

    public int amountOfTimeUsingAdjacencyList(TreeNode root, int start) {
        // Add parent Nodes
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        convert(root,0,adj);
        q.offer(start);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i< size ; i++){
                int check = q.poll();
                visited.add(check);
                for(int num:adj.get(check)){
                    if(!visited.contains(num)){
                        q.offer(num);
                    }
                }
            }
            time++;
        }
        return time-1;
    }

    public void convert(TreeNode root,int parent, Map<Integer,Set<Integer>> adj){
        if (root == null) {
            return;
        }

        if(!adj.containsKey(root.val)){
            adj.put(root.val, new HashSet<>());
        }
        Set<Integer> list = adj.get(root.val);
        if(parent!= 0){
            list.add(parent);
        }
        if(root.left!= null){
            list.add(root.left.val);
        }
        if(root.right!= null){
            list.add(root.right.val);
        }
        convert(root.left,root.val,adj);
        convert(root.right,root.val,adj);
    }


}

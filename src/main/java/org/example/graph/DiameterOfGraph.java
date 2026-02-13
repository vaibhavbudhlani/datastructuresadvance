package org.example.graph;

import java.util.ArrayList;

public class DiameterOfGraph {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // creating adjacency list
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 5);

        int res = diameter(adj);
        System.out.println(res);
    }

    private static int diameter(ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[2];
        int n = adj.size();

        helper(0,adj,0,ans, new boolean[n]);
        int end1 = ans[1];

        ans = new int[2];

        helper(end1,adj,0,ans,new boolean[n]);
        return ans[0];

    }

    public static void helper(int start, ArrayList<ArrayList<Integer>> adj, int dist,int[] ans, boolean[] visited){
        if(visited[start]){
            return;
        }
        if(ans[0] < dist){
            ans[0] = dist;
            ans[1] = start;
        }
        visited[start] = true;
        for(int next:adj.get(start)){
            if(!visited[next]){
                helper(next,adj,dist+1,ans,visited);
            }
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }


}

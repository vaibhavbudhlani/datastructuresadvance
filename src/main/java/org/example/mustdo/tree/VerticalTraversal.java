package org.example.mustdo.tree;

import java.util.*;

class Helper {
    int row;
    int col;
    TreeNode node;
}

class NodeInfo {
    int col, row, val;
    NodeInfo(int col, int row, int val) {
        this.col = col;
        this.row = row;
        this.val = val;
    }
}

public class VerticalTraversal {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        Integer[] arr1 =  {3,1,4,0,2,2};
        Integer[] arr2 = {20, 8, 22, 5, 3, 4, 25, null, null, 10, 14, null, null, 28, null};
        TreeNode root = TreeBuilder.buildTree(arr2);
        VerticalTraversal vt = new VerticalTraversal();
        vt.bottomView(root).forEach(System.out::println);
      //  List<List<Integer>> ans = vt.verticalTraversalUsingDFS(root);
        //System.out.println(ans);


    }

    public List<List<Integer>> verticalTraversalUsingBFS(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        // Map: col -> List of NodeInfo objects containing row and value
        Map<Integer, List<NodeInfo>> map = new TreeMap<>();
        Queue<Helper> q = new LinkedList<>();
        Helper obj = new Helper();
        obj.node = root;
        obj.row = 0;
        obj.col = 0;
        q.offer(obj);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Helper ob = q.poll();
                TreeNode node = ob.node;
                int row = ob.row;
                int col = ob.col;
                // Store NodeInfo with row and value for sorting later
                map.computeIfAbsent(col, k -> new ArrayList<>()).add(new NodeInfo(col, row, node.val));
                if (node.left != null) {
                    Helper helper = new Helper();
                    helper.node = node.left;
                    helper.row = row + 1;
                    helper.col = col - 1;
                    q.offer(helper);
                }
                if (node.right != null) {
                    Helper helper = new Helper();
                    helper.node = node.right;
                    helper.row = row + 1;
                    helper.col = col + 1;
                    q.offer(helper);
                }
            }
        }
        for (Map.Entry<Integer, List<NodeInfo>> entry : map.entrySet()) {
            List<NodeInfo> nodeList = entry.getValue();
            // Sort by row first, then by value if rows are same
            nodeList.sort((a, b) -> {
                if (a.row != b.row) return Integer.compare(a.row, b.row);
                return Integer.compare(a.val, b.val);
            });

            // Extract values and add to result
            List<Integer> values = new ArrayList<>();
            for (NodeInfo nodeInfo : nodeList) {
                values.add(nodeInfo.val);
            }
            ans.add(values);
        }
        return ans;
    }


    public List<List<Integer>> verticalTraversalUsingDFS(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfsNodeInfo(root, 0, 0, nodes);
        // Sort by col, then row, then value
        nodes.sort((a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });
        // Group by column using TreeMap
        TreeMap<Integer, List<Integer>> colMap = new TreeMap<>();
        for (NodeInfo node : nodes) {
            colMap.computeIfAbsent(node.col, k -> new ArrayList<>()).add(node.val);
        }
        return new ArrayList<>(colMap.values());
    }

    private void dfsNodeInfo(TreeNode node, int row, int col, List<NodeInfo> nodes) {
        if (node == null) return;
        nodes.add(new NodeInfo(col, row, node.val));
        dfsNodeInfo(node.left, row + 1, col - 1, nodes);
        dfsNodeInfo(node.right, row + 1, col + 1, nodes);
    }

    public ArrayList<Integer> bottomView(TreeNode root) {
        List<int[]> ls =new ArrayList<>();
        Map<Integer,Integer> tm = new TreeMap<>();
        dfs(root, ls,0 , 0);

        System.out.println(ls);
        ls.sort( (a,b) ->{
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            else if(a[1] != b[1]){
                return Integer.compare(b[1],a[1]);
            }
            else{
                return Integer.compare(b[2],a[2]);
            }
        });
        System.out.println(ls);
        for(int[] vb:ls){
            if(!tm.containsKey(vb[0])){
                tm.put(vb[0],vb[2]);
            }
        }
        return new ArrayList<>(tm.values());

    }


    public void dfs(TreeNode node,List<int[]> ls, int col, int row){
        if(node == null ){
            return;
        }
        ls.add(new int[]{col,row,node.val});
        dfs(node.left,ls, col-1, row+1);
        dfs(node.right, ls,col+1, row+1);
    }
}

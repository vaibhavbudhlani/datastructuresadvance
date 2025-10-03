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
        TreeNode root = TreeBuilder.buildTree(arr1);
        VerticalTraversal vt = new VerticalTraversal();
        List<List<Integer>> ans = vt.verticalTraversalUsingDFS(root);
        System.out.println(ans);


    }

    public List<List<Integer>> verticalTraversalUsingBFS(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        // Map: col -> List of (row, value)
        Map<Integer, List<int[]>> map = new TreeMap<>();
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
                // Store (row, value) for sorting later
                map.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
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
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> ls = entry.getValue();
            // Sort by row, then value
            ls.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            List<Integer> colList = new ArrayList<>();
            for (int[] pair : ls) {
                colList.add(pair[1]);
            }
            ans.add(colList);
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
}

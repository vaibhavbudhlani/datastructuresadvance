package org.example.mustdo.tree;
// Practice again

public class BSTtoGST {
    public static void main(String[] args) {
        Integer[] data = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = TreeBuilder.buildTree(data);
        BSTtoGST obj = new BSTtoGST();
        obj.bstToGst(root);
    }

    public int updateNode(TreeNode root, int sum) {
        if (root == null) return sum;
        root.val += updateNode(root.right, sum);
        return updateNode(root.left, root.val);
    }

    public TreeNode bstToGst(TreeNode root) {
        updateNode(root, 0);
        return root;
    }
}

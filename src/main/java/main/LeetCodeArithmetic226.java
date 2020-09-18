package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

/**
 * LeetCode第226题：反转二叉树(每日一题)
 */
public class LeetCodeArithmetic226 {
    public static void main(String[] args) {
        LeetCodeArithmetic226 leetCodeArithmetic226 = new LeetCodeArithmetic226();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode treeNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(treeNode);
        return treeNode;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

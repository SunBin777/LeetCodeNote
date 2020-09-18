package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode第94题：二叉树的中序遍历(每日一题)
 */
public class LeetCodeArithmetic94 {

    /**
     * 每日一题
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        insertTreeNode(integers , root);
        return integers;
    }
    public TreeNode insertTreeNode(List<Integer> integers,TreeNode root){
        if (root == null)
            return null;
        insertTreeNode(integers ,root.left);
        integers.add(root.val);
        insertTreeNode(integers ,root.right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

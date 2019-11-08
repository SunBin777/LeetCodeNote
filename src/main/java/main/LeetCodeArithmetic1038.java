package main;

/**
 * Create by 孙斌 on 2019/11/7.
 */

/**
 * LeetCode第1038题：字符串转换整数 (atoi)
 */
public class LeetCodeArithmetic1038 {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        System.out.println(bstToGst(treeNode));
    }

    public static TreeNode bstToGst(TreeNode root) {
        updateTree(root,0);
        return root;
    }

    /**  二叉树
     *                  4
     *           /          \
     *         1              6
     *        / \         /      \
     *      0    null    null     7
     *     /  \                 /    \
     *   null  null            null    8
     *                               /    \
     *                              null null
     * 每个节点只查找一次
     * 二叉树遍历 ↓
     * 所谓遍历(Traversal)是指沿着某条搜索路线，依次对树中每个结点均做一次且仅做一次访问。
     * 访问结点所做的操作依赖于具体的应用问 题。 遍历是二叉树上最重要的运算之一，是二叉树上进行其它运算之基础
     * @param root      树
     * @param number    总值
     * @return
     */
    public static int updateTree(TreeNode root, int number){
        //递归出口 如果查出null说明已经到二叉树的最后一个节点 null
        if(root == null){
            return number;
        }
        //采用递归 二叉树向右查找，到最后一个值的时候 开始往下进行，第一次 root（8）加 0 也就是 8
        //                                                          第二次 root（7）加 8 也就是 15 以此类推
        int right = updateTree(root.right,number);
        root.val += right;
        //向左一个节点查找
        return updateTree(root.left,root.val);
    }
}






/**
 * 二叉树结构
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

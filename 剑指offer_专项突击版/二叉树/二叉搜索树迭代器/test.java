package 剑指offer_专项突击版.二叉树.二叉搜索树迭代器;

import leetcode.热题100.hard.二叉树路径最大和.TreeNode;

public class test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7,new TreeNode(3),new TreeNode(15,new TreeNode(9),new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(root);
    }
}

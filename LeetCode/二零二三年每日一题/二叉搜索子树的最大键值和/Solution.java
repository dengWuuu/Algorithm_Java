package LeetCode.二零二三年每日一题.二叉搜索子树的最大键值和;

/**
 * @author Wu
 * @date 2023年05月21日 17:06
 */
public class Solution {
    int max = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int x = root.val;
        if (x <= l[1] && x >= r[0]) return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        int s = l[2] + r[2] + x;
        max = Math.max(max, s);
        return new int[]{Math.min(l[0], x), Math.max(x, r[1]), s};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
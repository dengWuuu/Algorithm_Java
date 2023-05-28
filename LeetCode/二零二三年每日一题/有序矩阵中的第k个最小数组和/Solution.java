package LeetCode.二零二三年每日一题.有序矩阵中的第k个最小数组和;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年05月28日 14:14
 * @email dengwu.wu@foxmail.com
 */
//https://leetcode.cn/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
public class Solution {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 5));
    }

    public static int kthSmallest(int[][] mat, int k) {
        int[] all = new int[]{0};
        for (int[] row : mat) {
            var b = new int[all.length * row.length];
            int i = 0;
            for (int x : all) {
                for (int y : row) {
                    b[i++] = x + y;
                }
            }
            Arrays.sort(b);
            if (b.length > k) b = Arrays.copyOfRange(b, 0, k);
            all = b;
        }
        return all[k - 1];
    }
}

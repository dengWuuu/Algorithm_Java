package leetcode.Contest_All.单周塞.周赛385.题3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */

public class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    Map<Integer, Integer> map = new HashMap<>();

    public int mostFrequentPrime(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int[] dir : dirs) {
                    dfs(0, mat, i, j, dir);
                }
            }
        }
        // 遍历map
        int maxValue = -1, times = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() < 10) continue;
            if (entry.getValue() > times) {
                maxValue = entry.getKey();
                times = entry.getValue();
            }
            if (entry.getValue() == times) {
                if (entry.getKey() > maxValue) {
                    maxValue = entry.getKey();
                }
            }

        }
        return maxValue;

    }

    public void dfs(int num, int[][] mat, int x, int y, int[] dir) {
        int i = x, j = y;
        while (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) map.put(num, map.getOrDefault(num, 0) + 1);
            i += dir[0];
            j += dir[1];
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

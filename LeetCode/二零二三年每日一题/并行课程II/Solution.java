package LeetCode.二零二三年每日一题.并行课程II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2023年06月17日 20:55
 */
public class Solution {
    List<List<Integer>> g = new ArrayList<>();

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            g.get(relation[0]).add(relation[1]);
        }

        return 0;
    }
}
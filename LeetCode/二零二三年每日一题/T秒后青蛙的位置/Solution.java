package LeetCode.二零二三年每日一题.T秒后青蛙的位置;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2023年05月24日 20:07
 */
public class Solution {

    List<List<Integer>> g = new ArrayList<>();

    public double frogPosition(int n, int[][] edges, int t, int target) {
        for (int i = 0; i < n + 1; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        g.get(1).add(0);
        boolean[] visit = new boolean[n + 1];
        Deque<double[]> d = new ArrayDeque<>();
        d.add(new double[]{1, 1});
        while (!d.isEmpty() && t >= 0) {
            int size = d.size();
            for (int i = 0; i < size; i++) {
                double[] p = d.poll();
                if (target == p[0]) {
                    if (t == 0 || g.get(target).size() == 1) return p[1];
                    else return 0;
                }
                int s = g.get((int) p[0]).size() - 1;
                if (s <= 0) continue;
                for (int point : g.get((int) p[0])) {
                    if (visit[point]) continue;
                    if (point == 0) continue;
                    visit[point] = true;
                    d.add(new double[]{point, p[1] / s});
                }
            }
            t--;
        }
        return 0;
    }
}
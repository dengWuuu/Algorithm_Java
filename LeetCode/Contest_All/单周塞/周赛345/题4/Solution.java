package LeetCode.Contest_All.单周塞.周赛345.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2023年05月14日 10:26
 */
public class Solution {
    List<List<Integer>> g = new ArrayList<>();
    int ans = 0;
    boolean[] v;
    int e, p;

    public int countCompleteComponents(int n, int[][] edges) {
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            e = 0;
            p = 0;
            dfs(i);
            ans += (e == p * (p - 1) ? 1 : 0);
        }
        return ans;
    }

    public void dfs(int i) {
        v[i] = true;
        p++;
        e += g.get(i).size();
        for (int nextPoint : g.get(i)) {
            if (!v[nextPoint]) dfs(nextPoint);
        }
    }
}
package leetcode.Y_2023.树上最大得分和路径;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2023年05月09日 11:07
 * @email dengwu.wu@foxmail.com
 */
//https://leetcode.cn/problems/most-profitable-path-in-a-tree/
public class Solution {
    List<List<Integer>> g = new ArrayList<>();
    int[] costs;
    int[] amount;
    int ans;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        this.amount = amount;
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        dfs_bob(bob, -1, 0);

        g.get(0).add(-1);
        ans = Integer.MIN_VALUE;
        dfs_alice(0, -1, 0, 0);
        return ans;
    }

    public void dfs_alice(int x, int fa, int time, int total) {
        if (time < costs[x]) {
            total += amount[x];
        } else if (time == costs[x]) {
            total += amount[x] / 2;
        }
        if (g.get(x).size() == 1) {
            ans = Math.max(ans, total);
            return;
        }
        for (int p : g.get(x)) {
            if (p != fa) {
                dfs_alice(p, x, time + 1, total);
            }
        }
    }

    public boolean dfs_bob(int x, int fa, int time) {
        if (x == 0) {
            costs[x] = time;
            return true;
        }
        boolean f = false;
        for (int p : g.get(x)) {
            if (p != fa) {
                if (dfs_bob(p, x, time + 1)) {
                    f = true;
                    costs[x] = time;
                }
            }
        }
        return f;
    }
}
package leetcode.Y_2024.三月.有向无环图中一个节点的所有祖先;

import java.util.*;

/**
 * @author Wu
 * @date 2024年04月04日 13:55
 */
public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
        }

        List<Integer>[] ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int start = 0; start < n; start++) {
            dfs(start, start, g, vis, ans); // 从 start 开始 DFS
        }
        return Arrays.asList(ans);
    }

    private void dfs(int x, int start, List<Integer>[] g, int[] vis, List<Integer>[] ans) {
        vis[x] = start; // 避免重复访问
        for (int y : g[x]) {
            if (vis[y] != start) {
                ans[y].add(start); // start 是访问到的点的祖先
                dfs(y, start, g, vis, ans); // 只递归没有访问过的点
            }
        }
    }
}
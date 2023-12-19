package leetcode.Contest_All.单周塞.周赛357.题3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2023年08月06日 16:38
 */
public class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        Deque<int[]> d = new ArrayDeque<>();
        int[][] dis = new int[m][n];
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    d.add(new int[]{i, j});
                    dis[i][j] = 0;
                    v[i][j] = true;
                }
            }
        }
        while (!d.isEmpty()) {
            int[] poll = d.poll();
            int x = poll[0], y = poll[1];
            for (int[] dir : dirs) {
                int nx = dir[0] + x, ny = dir[1] + y;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (v[nx][ny]) continue;
                v[nx][ny] = true;
                d.add(new int[]{nx, ny});
                dis[nx][ny] = dis[x][y] + 1;
            }
        }
        int l = 0, r = Math.min(dis[0][0], dis[m - 1][n - 1]) + 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (check(mid, dis)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public boolean check(int limit, int[][] dis) {
        if (dis[0][0] < limit) return false;
        Deque<int[]> d = new ArrayDeque<>();
        d.add(new int[]{0, 0});
        int m = dis.length;
        int n = dis[0].length;
        boolean[][] v = new boolean[m][n];
        v[0][0] = true;
        while (!d.isEmpty()) {
            int[] poll = d.poll();
            int x = poll[0], y = poll[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (v[nx][ny]) continue;
                if (dis[nx][ny] < limit) continue;
                d.add(new int[]{nx, ny});
                v[nx][ny] = true;
            }
        }
        return v[m - 1][n - 1];
    }
}
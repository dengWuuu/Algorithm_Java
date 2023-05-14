package LeetCode.周赛总.单周塞.周赛345.题3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2023年05月14日 10:26
 */
public class Solution {
    public int maxMoves(int[][] grid) {
        int cnt = 0;
        Deque<int[]> d = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            d.add(new int[]{i, 0});
        }
        int[][] dirs = new int[][]{{0, 1}, {-1, 1}, {1, 1}};
        while (!d.isEmpty()) {
            int size = d.size();
            for (int i = 0; i < size; i++) {
                int[] poll = d.poll();
                int x = poll[0], y = poll[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (set.contains(nx + "_" + ny)) continue;
                    if (nx >= grid.length || nx < 0 || ny >= grid[0].length || ny < 0) continue;
                    if (grid[nx][ny] <= grid[x][y]) continue;
                    set.add(nx + "_" + ny);
                    d.add(new int[]{nx, ny});
                }
            }
            if (!d.isEmpty()) cnt++;
        }
        return cnt;
    }
}

package LeetCode.Contest_All.双周赛.双周赛108.题4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2023年07月09日 15:08
 */
public class Solution {
    Set<String> visit = new HashSet<>();

    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] ans = new long[5];
        long all = (long) (m - 1) * (n - 1);
        Set<String> black = new HashSet<>();
        for (int[] coordinate : coordinates) {
            black.add(coordinate[0] + "_" + coordinate[1]);
        }
        for (int[] coordinate : coordinates) {
            int x = coordinate[0], y = coordinate[1];
            for (int j = Math.max(0, x - 1); j <= x && j < m - 1; j++) {
                for (int k = Math.max(0, y - 1); k <= y && k < n - 1; k++) {
                    if (visit.contains(j + "_" + k)) continue;
                    visit.add(j + "_" + k);
                    int cnt = 0;
                    if (black.contains(j + "_" + k)) cnt++;
                    if (black.contains(j + "_" + (k + 1))) cnt++;
                    if (black.contains(j + 1 + "_" + k)) cnt++;
                    if (black.contains(j + 1 + "_" + (k + 1))) cnt++;
                    ans[cnt]++;
                }
            }
        }
        ans[0] = all - visit.size();
        return ans;
    }
}
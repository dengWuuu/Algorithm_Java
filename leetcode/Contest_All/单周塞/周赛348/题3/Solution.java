package leetcode.Contest_All.单周塞.周赛348.题3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2023年06月04日 14:56
 */
public class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (type == 0) {
                if (row.contains(index)) continue;
                ans += (long) val * (n - col.size());
                row.add(index);
            }
            if (type == 1) {
                if (col.contains(index)) continue;
                ans += (long) val * (n - row.size());
                col.add(index);
            }
        }
        return ans;
    }
}

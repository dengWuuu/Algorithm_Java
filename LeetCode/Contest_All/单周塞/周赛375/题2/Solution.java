package leetcode.Contest_All.单周塞.周赛375.题2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */
public class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            int total = a;
            for (int j = 0; j < b - 1; j++) {
                total *= a;
                total %= 10;
            }
            total %= 10;
            // ci次方
            a = total;
            for (int j = 0; j < c - 1; j++) {
                total *= a;
                total %= m;
            }
            total %= m;
            if (total == target) ans.add(i);
        }
        return ans;
    }
}

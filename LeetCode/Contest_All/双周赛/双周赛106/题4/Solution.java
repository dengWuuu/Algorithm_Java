package LeetCode.Contest_All.双周赛.双周赛106.题4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < grid.length; i++) {
            StringBuilder binary = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                binary.append(grid[i][j]);
            }
            map.put(binary.toString(), i);

        }
        return ans;
    }
}
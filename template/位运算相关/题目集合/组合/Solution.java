package template.位运算相关.题目集合.组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int mask = 1 << n;
        for (int i = 0; i < mask; i++) {
            path.clear();
            if (Integer.bitCount(i) == k) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) path.add(j + 1);
                }
                ans.add(new ArrayList<>(path));
            }
        }
        return ans;
    }
}
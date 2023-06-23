package template.位运算相关.题目集合.子集;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length, mask = 1 << n;
        // mask 代表哪几位被选择了 例如： 000001 代表 第0位是1， nums中第0位被选择了
        for (int i = 0; i < mask; i++) {
            path.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) path.add(nums[j]);
            }
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }
}
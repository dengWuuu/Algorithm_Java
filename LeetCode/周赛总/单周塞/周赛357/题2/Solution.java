package LeetCode.周赛总.单周塞.周赛357.题2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2023年08月06日 16:38
 */
public class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() < 3) return true;
        for (int i = nums.size() - 1; i >= 1; i--) {
            if (nums.get(i) + nums.get(i - 1) >= m) return true;
        }
        return false;
    }
}
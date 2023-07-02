package LeetCode.周赛总.单周塞.周赛352.题4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2023年07月02日 13:31
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.clear();
            map.put(nums[i], 1);
            int cnt = 0;

            for (int j = i + 1; j < nums.length; j++) {
                if (map.getOrDefault(nums[j], 0) != 1) {
                    cnt++;
                    if (map.getOrDefault(nums[j] + 1, 0) == 1) cnt--;
                    if (map.getOrDefault(nums[j] - 1, 0) == 1) cnt--;
                    map.put(nums[j], 1);
                }
                ans += cnt;
            }
        }
        return ans;
    }
}

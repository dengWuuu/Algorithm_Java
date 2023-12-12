package LeetCode.Contest_All.单周塞.周赛375.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */
public class Solution {
    int MOD = (int) (1e9 + 7);

    public int numberOfGoodPartitions(int[] nums) {
        long ans = 1;
        // 统计多少个不可分割的区间 然后2次幂即可
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[1] = i;
            } else {
                map.put(nums[i], new int[]{i, i});
            }
        }
        List<int[]> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(o -> o[0]));

        // 区间合并
        int rDis = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] > rDis) {
                ans *= 2;
                ans %= MOD;
            }
            rDis = Math.max(rDis, list.get(i)[1]);
        }


        return (int) ans;
    }
}

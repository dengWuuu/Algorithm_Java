package leetcode.Contest_All.单周塞.周赛354.题3;

import java.util.*;

/**
 * @author Wu
 * @date 2023年07月16日 13:10
 */
public class Solution {
    Map<Integer, Integer> cnt = new HashMap<>();


    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        for (Integer num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int val = -1;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() > max) {
                val = e.getKey();
                max = e.getValue();
            }
        }

        int c = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num == val) c++;
            if (c * 2 > i + 1 && (max - c) * 2 > (n - i - 1)) return i;
        }

        return -1;
    }
}
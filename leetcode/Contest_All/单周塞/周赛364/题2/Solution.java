package leetcode.Contest_All.单周塞.周赛364.题2;

import java.util.List;

/**
 * @author Wu
 * @date 2023年09月24日 10:20
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            ans = Math.max(get(maxHeights, i), ans);
        }
        return ans;
    }

    public long get(List<Integer> maxHeights, int idx) {
        long ans = maxHeights.get(idx);
        long cur = ans;
        for (int i = idx + 1; i < maxHeights.size(); i++) {
            cur = Math.min(cur, maxHeights.get(i));
            ans += cur;
        }
        cur = maxHeights.get(idx);
        for (int i = idx - 1; i >= 0; i--) {
            cur = Math.min(cur, maxHeights.get(i));
            ans += cur;
        }

        return ans;
    }
}
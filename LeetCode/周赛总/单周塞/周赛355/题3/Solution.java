package LeetCode.周赛总.单周塞.周赛355.题3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wu
 * @date 2023年07月23日 15:33
 */
public class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        long ans = 0;
        long cur = 0;
        Collections.sort(usageLimits);
        for (int i = 0; i < n; i++) {
            cur += usageLimits.get(i);
            if (cur >= ans + 1) {
                ans++;
                cur -= ans;
            }
        }
        return (int) ans;
    }
}
package LeetCode.周赛总.单周塞.周赛345.题1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2023年05月14日 10:26
 */
public class Solution {
    public  int[] circularGameLosers(int n, int k) {
        int[] cnt = new int[n];
        int cur = 0;
        int tmp = k;
        while (true) {
            cnt[cur]++;
            if (cnt[cur] == 2) break;
            cur = cur + tmp;
            cur %= n;

            tmp += k;
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == 0) l.add(i + 1);
        }
        int[] ans = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
}
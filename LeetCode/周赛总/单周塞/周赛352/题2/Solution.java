package LeetCode.周赛总.单周塞.周赛352.题2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Wu
 * @date 2023年07月02日 13:31
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    static boolean[] zhishu = new boolean[(int) (1e6 + 10)];

    static {
        int n = (int) (1e6 + 9);
        Arrays.fill(zhishu, true);
        zhishu[0] = false;
        zhishu[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (zhishu[i]) {
                for (int j = i * i; j <= n; j += i) {
                    zhishu[j] = false;
                }
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        int l = 1, r = n - 1;
        while (l <= r) {
            if (!zhishu[l]) {
                l++;
                r--;
                continue;
            }
            if (!zhishu[r]) {
                l++;
                r--;
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(l);
            tmp.add(r);
            ans.add(tmp);
            l++;
            r--;
        }
        return ans;
    }
}
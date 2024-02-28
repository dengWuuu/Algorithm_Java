package leetcode.Contest_All.单周塞.周赛385.题2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */
public class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < arr1.length; j++) {
                String s = String.valueOf(arr1[j]);
                String pre = s.substring(0, Math.min(s.length(), i + 1));
                set1.add(pre);
            }
            for (int j = 0; j < arr2.length; j++) {
                String s = String.valueOf(arr2[j]);
                String pre = s.substring(0, Math.min(s.length(), i + 1));
                if (set1.contains(pre)) ans = Math.max(pre.length(), ans);
            }
        }

        return ans;
    }
}

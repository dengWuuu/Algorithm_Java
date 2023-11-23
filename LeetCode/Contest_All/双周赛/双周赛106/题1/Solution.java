package LeetCode.Contest_All.双周赛.双周赛106.题1;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {
    public boolean isFascinating(int n) {
        String end = String.valueOf(n) + String.valueOf(n * 2) + String.valueOf(n * 3);
        int[] cnt = new int[10];
        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == '0') return false;
            else {
                cnt[end.charAt(i) - '0']++;
                if (cnt[end.charAt(i) - '0'] == 2) return false;
            }
        }
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] != 1) return false;
        }
        return true;
    }
}
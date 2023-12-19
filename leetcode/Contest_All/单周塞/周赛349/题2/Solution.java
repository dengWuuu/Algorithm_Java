package leetcode.Contest_All.单周塞.周赛349.题2;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {
    public String smallestString(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a') {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            c[n - 1] = c[n - 1] == 'a' ? 'z' : (char) (c[n - 1] - 1);
            return String.valueOf(c);
        }
        int r = -1;
        for (int i = idx; i < n; i++) {
            if (s.charAt(i) != 'a') {
                r = i;
            } else break;
        }

        for (int i = idx; i <= r; i++) {
            c[i] = c[i] == 'a' ? 'z' : (char) (c[i] - 1);
        }
        return String.valueOf(c);
    }
}
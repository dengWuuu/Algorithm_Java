package leetcode.Contest_All.单周塞.周赛346.题2;

/**
 * @author Wu
 * @date 2023年05月21日 10:26
 */
public class Solution {
    public String makeSmallestPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] sb = s.toCharArray();
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
            } else {
                if (s.charAt(l) < s.charAt(r)) {
                    sb[r] = sb[l];
                } else {
                    sb[l] = sb[r];
                }
            }
            l++;
            r--;
        }
        return String.valueOf(sb);
    }
}
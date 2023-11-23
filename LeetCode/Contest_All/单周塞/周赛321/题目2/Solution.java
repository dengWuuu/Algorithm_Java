package LeetCode.Contest_All.单周塞.周赛321.题目2;

/**
 * @author Wu
 * @date 2022年11月20日 9:56
 */
public class Solution {
    public int appendCharacters(String s, String t) {
        int l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                r++;
            }
            l++;
        }

        return t.length() - r;
    }
}
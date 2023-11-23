package LeetCode.Contest_All.单周塞.周赛346.题1;

/**
 * @author Wu
 * @date 2023年05月21日 10:26
 */
public class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            int num = s.indexOf("AB");
            if (num >= 0) {
                s = s.substring(0, num) + s.substring(num + 2);
            }

            num = s.indexOf("CD");
            if (num >= 0) {
                s = s.substring(0, num) + s.substring(num + 2);
            }
        }
        return s.length();
    }
}

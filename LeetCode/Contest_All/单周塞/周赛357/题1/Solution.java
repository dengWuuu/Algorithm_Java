package LeetCode.Contest_All.单周塞.周赛357.题1;

/**
 * @author Wu
 * @date 2023年08月06日 16:38
 */
public class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i') {
                sb.append(s.charAt(i));
            }else {
                sb.reverse();
            }
        }
        return sb.toString();
    }
}
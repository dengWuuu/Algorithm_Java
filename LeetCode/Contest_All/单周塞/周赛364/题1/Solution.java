package LeetCode.Contest_All.单周塞.周赛364.题1;

/**
 * @author Wu
 * @date 2023年09月24日 10:20
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') cnt0++;
            else cnt1++;
        }
        sb.append("1");
        cnt1--;
        while (cnt0 > 0) {
            sb.insert(0, "0");
            cnt0--;
        }
        while (cnt1 > 0) {
            sb.insert(0, "1");
            cnt1--;
        }
        return sb.toString();
    }
}
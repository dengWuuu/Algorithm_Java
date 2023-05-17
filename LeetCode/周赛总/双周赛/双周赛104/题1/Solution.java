package LeetCode.周赛总.双周赛.双周赛104.题1;

/**
 * @author Wu
 * @date 2023年05月13日 19:31
 */
public class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (int i = 0; i < details.length; i++) {
            String age = details[i].substring(11, 13);
            int num = Integer.parseInt(age);
            if (num > 60) cnt++;
        }
        return cnt;
    }
}
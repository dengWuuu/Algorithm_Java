package LeetCode.周赛总.单周塞.周赛345.题2;

/**
 * @author Wu
 * @date 2023年05月14日 10:26
 */
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= derived[i];
        }
        return sum == 0;
    }
}
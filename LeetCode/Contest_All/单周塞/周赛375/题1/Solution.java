package LeetCode.Contest_All.单周塞.周赛375.题1;

/**
 * @author Wu
 * @date 2023年12月12日 13:44
 */
public class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                ans++;
                for (int j = i; j < batteryPercentages.length; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return ans;
    }
}

package leetcode.Contest_All.双周赛.双周赛97.题3;

/**
 * @author Wu
 * @date 2023年12月08日 11:05
 */
// https://leetcode.cn/problems/minimum-incompatibility/description/
public class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int ans = 0, left = 0;
        int[] preMax = new int[prizePositions.length + 10];
        for (int i = 0; i < prizePositions.length; i++) {
            while (prizePositions[i] - prizePositions[left] > k) left++;
            ans = Math.max(ans, i - left + 1 + preMax[left]);
            preMax[i + 1] = Math.max(preMax[i], i - left + 1);
        }
        return ans;
    }
}

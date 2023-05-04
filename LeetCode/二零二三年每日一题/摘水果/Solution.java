package LeetCode.二零二三年每日一题.摘水果;

/**
 * @author Wu
 * @date 2023年05月04日 19:38
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int l = getLowerBound(fruits, startPos - k);
        int r = l, sum = 0, n = fruits.length;
        while (r < n && fruits[r][0] <= startPos) {
            sum += fruits[r][1];
            r++;
        }
        int ans = sum;
        for (; r < n && fruits[r][0] <= startPos + k; r++) {
            sum += fruits[r][1];
            while (fruits[r][0] * 2 - fruits[l][0] - startPos > k && fruits[r][0] - fruits[l][0] * 2 + startPos > k) {
                sum -= fruits[l++][1];
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }


    public int getLowerBound(int[][] fruits, int target) {
        int l = -1, r = fruits.length;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (fruits[mid][0] < target) {
                l = mid;
            } else r = mid;
        }
        return r;
    }
}

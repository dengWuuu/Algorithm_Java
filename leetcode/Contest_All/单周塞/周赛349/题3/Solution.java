package leetcode.Contest_All.单周塞.周赛349.题3;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {

    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            sum += nums[i];
        }

        long cost;
        for (int i = 1; i < n; i++) {
            cost = (long) i * x;
            if (cost > sum) {
                break;
            }
            for (int j = 0; j < n; j++) {
                arr[j] = Math.min(arr[j], nums[(i + j) % n]);
                cost += arr[j];
            }
            if (cost < sum) {
                sum = cost;
            }

        }
        return sum;
    }
}
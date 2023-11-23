package LeetCode.Contest_All.单周塞.周赛364.题3;

import java.util.*;

/**
 * @author Wu
 * @date 2023年09月24日 10:20
 * @email dengwu.wu@foxmail.com
 */
// 想想山峰的特点
public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> maxHeights = new ArrayList<>();
        maxHeights.add(5);
        maxHeights.add(3);
        maxHeights.add(4);
        maxHeights.add(1);
        maxHeights.add(1);
        maximumSumOfHeights(maxHeights);
    }

    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        int n = maxHeights.size();
        Deque<Integer> stack = new ArrayDeque<>();
        long[] left = new long[n + 1], right = new long[n + 1];
        stack.add(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && maxHeights.get(stack.peekLast()) >= maxHeights.get(i)) {
                stack.pollLast();
            }
            left[i + 1] = left[stack.peekLast() + 1] + (long) maxHeights.get(i) * (i - stack.peekLast());
            stack.addLast(i);
        }
        stack.clear();
        stack.add(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && maxHeights.get(stack.peekLast()) >= maxHeights.get(i)) {
                stack.pollLast();
            }
            right[i] = right[stack.peekLast()] + (long) maxHeights.get(i) * (stack.peekLast() - i);
            stack.add(i);
            ans = Math.max(ans, right[i] + left[i + 1] - maxHeights.get(i));
        }
        return ans;
    }
}
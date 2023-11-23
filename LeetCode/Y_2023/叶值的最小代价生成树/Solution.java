package LeetCode.Y_2023.叶值的最小代价生成树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2023年06月01日 15:46
 */
public class Solution {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int x : arr) {
            while (!stack.isEmpty() && stack.peek() <= x) {
                int y = stack.pop();
                if (stack.isEmpty() || stack.peek() > x) {
                    ans += y * x;
                } else {
                    ans += stack.peek() * y;
                }
            }
            stack.push(x);
        }
        while (stack.size() >= 2) {
            int pop = stack.pop();
            ans += pop * stack.peek();
        }
        return ans;
    }
}
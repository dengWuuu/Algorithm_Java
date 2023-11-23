package LeetCode.Contest_All.单周塞.周赛351.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2023年06月25日 20:00
 * @email dengwu.wu@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR"));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        int[][] p = new int[positions.length][2];
        for (int i = 0; i < positions.length; i++) {
            p[i][0] = i;
            p[i][1] = positions[i];
        }
        Arrays.sort(p, Comparator.comparingInt(x -> x[1]));
        Deque<int[]> stack = new ArrayDeque<>();
        List<int[]> tmp = new ArrayList<>();
        for (int[] ints : p) {
            int idx = ints[0];
            if (directions.charAt(idx) == 'R') {
                stack.push(ints);
            } else {
                while (!stack.isEmpty() && healths[stack.peek()[0]] < healths[idx]) {
                    stack.pop();
                    healths[idx]--;
                }
                if (healths[idx] == 0) continue;
                if (!stack.isEmpty()) {
                    if (healths[stack.peek()[0]] == healths[idx]) {
                        stack.pop();
                    } else {
                        healths[stack.peek()[0]]--;
                    }
                } else {
                    tmp.add(ints);
                }
            }
        }
        while (!stack.isEmpty()) {
            tmp.add(stack.pop());
        }
        tmp.sort(Comparator.comparingInt(o -> o[0]));
        for (int[] ints : tmp) {
            ans.add(healths[ints[0]]);
        }
        return ans;
    }

}

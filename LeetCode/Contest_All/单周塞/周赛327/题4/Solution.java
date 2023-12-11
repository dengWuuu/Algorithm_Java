package LeetCode.Contest_All.单周塞.周赛327.题4;

import java.util.PriorityQueue;

/**
 * @author Wu
 * @date 2023年12月11日 12:18
 */
public class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        // 定义等待中的工人优先级比较规则，时间总和越高，效率越低，优先级越低，越优先被取出
        PriorityQueue<Integer> waitLeft = new PriorityQueue<>((x, y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });
        PriorityQueue<Integer> waitRight = new PriorityQueue<>(waitLeft.comparator());

        PriorityQueue<int[]> workLeft = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });
        PriorityQueue<int[]> workRight = new PriorityQueue<>(workLeft.comparator());

        int boxs = n, curTime = 0;
        for (int i = 0; i < k; i++) {
            waitLeft.offer(i);
        }
        // 所有人需要回到左边 或者 还有箱子
        while (boxs > 0 || !workRight.isEmpty() || !waitRight.isEmpty()) {
            while (!workLeft.isEmpty() && workLeft.peek()[0] <= curTime) {
                waitLeft.offer(workLeft.poll()[1]);
            }
            while (!workRight.isEmpty() && workRight.peek()[0] <= curTime) {
                waitRight.offer(workRight.poll()[1]);
            }

            if (!waitRight.isEmpty()) {
                int id = waitRight.poll();
                curTime += time[id][2];
                workLeft.offer(new int[]{curTime + time[id][3], id});
            } else if (boxs > 0 && !waitLeft.isEmpty()) {
                int id = waitLeft.poll();
                curTime += time[id][0];
                workRight.offer(new int[]{curTime + time[id][1], id});
                boxs--;
            } else {
                int nextTime = Integer.MAX_VALUE;
                if (!workLeft.isEmpty()) {
                    nextTime = Math.min(nextTime, workLeft.peek()[0]);
                }
                if (!workRight.isEmpty()) {
                    nextTime = Math.min(nextTime, workRight.peek()[0]);
                }
                if (nextTime != Integer.MAX_VALUE) {
                    curTime = Math.max(nextTime, curTime);
                }
            }
        }
        return curTime;
    }
}
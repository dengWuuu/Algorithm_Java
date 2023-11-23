package LeetCode.Contest_All.单周塞.周赛351.题2;

/**
 * @author Wu
 * @date 2023年06月25日 20:00
 * @email dengwu.wu@foxmail.com
 */
public class Solution {

    public int makeTheIntegerZero(int num1, int num2) {
        if (num1 == 0) return 0;
        int cnt = 0;
        long n1 = num1;
        while (true) {
            cnt++;
            n1 -= num2;
            if (n1 <= 0) return -1;
            int count = Long.bitCount(n1);
            if (cnt >= count && n1 >= cnt) return cnt;
        }
    }
}

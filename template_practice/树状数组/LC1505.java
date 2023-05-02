package template_practice.树状数组;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2023年05月02日 14:52
 */
public class LC1505 {
    public String minInteger(String num, int k) {
        int n = num.length();
        Deque<Integer>[] pos = new Deque[10];
        for (int i = 0; i < 10; i++) {
            pos[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[num.charAt(i) - '0'].add(i + 1);            //记录坐标 从1开始
        }

        StringBuilder ans = new StringBuilder();

        BIT_LC1505 t = new BIT_LC1505(n + 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (!pos[j].isEmpty()) {
                    int behind = t.query(pos[j].peek() + 1, n);     //后面有几个动了的
                    int dist = pos[j].peek() + behind - i;
                    if (dist <= k) {
                        t.inc(pos[j].poll());
                        ans.append(j);
                        k -= dist;
                        break;
                    }
                }
            }
        }
        return ans.toString();

    }
}


class BIT_LC1505 {
    private final int[] tree;

    public BIT_LC1505(int n) {
        tree = new int[n];
    }

    // 将下标 i 上的数加一
    public void inc(int i) {
        while (i < tree.length) {
            ++tree[i];
            i += i & -i;
        }
    }

    // 返回闭区间 [1, i] 的元素和
    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x &= x - 1;
        }
        return res;
    }

    // 返回闭区间 [left, right] 的元素和
    public int query(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}
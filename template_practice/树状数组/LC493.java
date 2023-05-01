package template_practice.树状数组;

import java.util.*;

/**
 * @author Wu
 * @date 2023年05月01日 20:21
 */
//https://leetcode.cn/problems/reverse-pairs/
public class LC493 {
    public int reversePairs(int[] nums) {
        Set<Long> all = new TreeSet<>();
        for (int num : nums) {
            all.add((long) num);
            all.add(num * 2L);
        }
        Map<Long, Integer> map = new HashMap<>();
        int idx = 1;
        for (Long aLong : all) {
            map.put(aLong, idx++);
        }
        BIT_LC493 t = new BIT_LC493(map.size() + 1);
        int res = 0;

        for (int num : nums) {
            int left = map.get(num * 2L), right = map.size();
            res += t.query(left + 1, right);
            t.inc(map.get((long) num));
        }
        return res;
    }
}

class BIT_LC493 {
    private final int[] tree;

    public BIT_LC493(int n) {
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
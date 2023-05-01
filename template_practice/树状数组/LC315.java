package template_practice.树状数组;

import java.util.*;

/**
 * @author Wu
 * @date 2023年05月01日 20:53
 */
//https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
public class LC315 {
    public List<Integer> countSmaller(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i : set) {
            map.put(i, idx++);
        }

        BIT_LC315 t = new BIT_LC315(map.size() + 1);
        List<Integer> ans = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(0, t.query(1, map.get(nums[i]) - 1));
            t.inc(map.get(nums[i]));
        }
        return ans;
    }
}

class BIT_LC315 {
    private final int[] tree;

    public BIT_LC315(int n) {
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

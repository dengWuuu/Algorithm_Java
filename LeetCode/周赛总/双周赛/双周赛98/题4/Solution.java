package LeetCode.周赛总.双周赛.双周赛98.题4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
//TODO 补线段树
public class Solution {
    class Node {
        Node left;
        Node right;
        int l;
        int r;
        boolean lazy;
        int totalSum;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public Node build(int[] nums, int l, int r) {
        if (l == r) {
            Node ans = new Node(l, r);
            ans.totalSum = nums[l];
            return ans;
        }
        int middle = l + (r - l) / 2;
        Node ans = new Node(l, r);
        ans.left = build(nums, l, middle);
        ans.right = build(nums, middle + 1, r);
        ans.totalSum = ans.left.totalSum + ans.right.totalSum;
        return ans;
    }

    private void pushDown(Node node) {
        if (node.lazy) {
            node.lazy = false;
            node.left.lazy = !node.left.lazy;
            node.right.lazy = !node.right.lazy;
            node.left.totalSum = node.left.r - node.left.l + 1 - node.left.totalSum;
            node.right.totalSum = node.right.r - node.right.l + 1 - node.right.totalSum;
        }
    }

    private void pushUp(Node node) {
        node.totalSum = node.left.totalSum + node.right.totalSum;
    }

    public void update(Node node, int l, int r) {
        int left = node.l;
        int right = node.r;
        if (left > r || right < l) return;
        if (left >= l && right <= r) {
            node.lazy = !node.lazy;
            node.totalSum = right - left + 1 - node.totalSum;
            return;
        }
        pushDown(node);
        update(node.left, l, r);
        update(node.right, l, r);
        pushUp(node);
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        Node root = build(nums1, 0, nums1.length - 1);
        long ans = 0;

        for (int i = 0; i < nums2.length; i++) {
            ans += nums2[i];
        }

        List<Long> ansList = new ArrayList<>();

        for (int[] query : queries) {
            int idx = query[0];
            if (idx == 1) {
                update(root, query[1], query[2]);
            } else if (idx == 2) {
                ans += (long) query[1] * root.totalSum;
            } else {
                ansList.add(ans);
            }
        }
        return ansList.stream().mapToLong(x -> x).toArray();

    }
}
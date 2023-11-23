package LeetCode.Y_2023.树节点的第K个祖先;

/**
 * @author Wu
 * @date 2023年06月13日 23:12
 */
public class TreeAncestor {
    int[][] pa;

    public TreeAncestor(int n, int[] parent) {
        int m = 32 - Integer.numberOfLeadingZeros(n);
        pa = new int[n][m];
        for (int i = 0; i < n; i++) {
            pa[i][0] = parent[i];
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int p = pa[j][i];
                pa[j][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) == 1) {
                node = pa[node][i];
                if (node == -1) break;
            }
        }
        return node;
    }
}
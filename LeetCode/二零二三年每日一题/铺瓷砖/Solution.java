package LeetCode.二零二三年每日一题.铺瓷砖;

/**
 * @author Wu
 * @date 2023年06月08日 22:35
 */
public class Solution {
    boolean[][] cover;
    int ans = Integer.MAX_VALUE;

    public int tilingRectangle(int n, int m) {
        cover = new boolean[n][m];
        dfs(0);
        return ans;
    }

    public void dfs(int cnt) {
        if (ans <= cnt) return;
        int[] emptyPos = checkEmpty(); // 地上没瓷砖的第一个位置
        if (emptyPos[0] == -1 && emptyPos[1] == -1) {
            ans = cnt;
            return;
        }
        // 从大到小，开始尝试铺瓷砖
        int maxLen = Math.min(cover.length - emptyPos[0], cover[0].length - emptyPos[1]);
        for (int len = maxLen; len >= 1; len--) {
            // 尝试用len*len的瓷砖的左上角去对齐地上没瓷砖的这个位置
            if (setStatus(emptyPos[0], emptyPos[1], emptyPos[0] + len - 1, emptyPos[1] + len - 1, false)) {
                dfs(cnt + 1);
                setStatus(emptyPos[0], emptyPos[1], emptyPos[0] + len - 1, emptyPos[1] + len - 1, true);
            }
        }
    }

    // reverse代表是否需要是dfs的反转阶段
    private boolean setStatus(int row1, int col1, int row2, int col2, boolean reverse) {
        //需要都没铺过 或者 铺过
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (cover[i][j] != reverse) {
                    return false;
                }
            }
        }
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                cover[i][j] = !cover[i][j];
            }
        }
        return true;
    }

    // 顺序遍历寻找第一个没铺瓷砖的位置（从上到下，从左到右）
    private int[] checkEmpty() {
        for (int i = 0; i < cover.length; i++) {
            for (int j = 0; j < cover[0].length; j++) {
                if (!cover[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
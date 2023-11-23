package LeetCode.Contest_All.单周塞.周赛346.题3;

/**
 * @author Wu
 * @date 2023年05月21日 10:26
 */
public class Solution {
    public static void main(String[] args) {
        int num = 37;
        System.out.println(dfs(String.valueOf(num * num), 0, 0, num));
    }

    public static int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            if (dfs(String.valueOf(num), 0, 0, i)) ans += num;
        }
        return ans;
    }

    public static boolean dfs(String s, int idx, int cnt, int i) {
        if (cnt == i && idx == s.length()) {
            return true;
        }
        boolean f = false;
        for (int j = idx; j < s.length(); j++) {
            String cut = s.substring(idx, j + 1);
            cnt += Integer.parseInt(cut);
            boolean ff = dfs(s, j + 1, cnt, i);
            cnt -= Integer.parseInt(cut);
            if (ff) {
                f = true;
                break;
            }
        }
        return f;
    }
}
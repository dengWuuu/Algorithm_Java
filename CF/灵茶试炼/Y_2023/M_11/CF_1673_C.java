package CF.灵茶试炼.Y_2023.M_11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年10月31日 17:39
 */
// https://codeforces.com/problemset/problem/1673/C
public class CF_1673_C {
    int MOD = (int) (1e9 + 7);

    public void solve() {
        Kattio io = new Kattio();
        int T = io.nextInt();
        // 预处理4e4的回文数
        List<Integer> p = new ArrayList<>();
        for (int i = 1; i <= 4e4; i++) {
            if (isP(i)) p.add(i);
        }
        // dp出每个数字的回文组合
        long[] dp = new long[(int) (4e4 + 1)];
        dp[0] = 1;
        for (Integer i : p) {
            for (int j = i; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - i] % MOD;
                dp[j] %= MOD;
            }
        }
        for (int i = 0; i < T; i++) {
            int n = io.nextInt();
            io.println(dp[n]);

        }
        io.flush();
        io.close();
    }

    public boolean isP(int num) {
        String n = String.valueOf(num);
        int l = 0, r = n.length() - 1;
        while (l < r) {
            if (n.charAt(l) == n.charAt(r)) {
                l++;
                r--;
            } else return false;
        }
        return true;
    }

    public static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        // 标准 IO
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // 文件 IO
        public Kattio(String input, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(input));
        }

        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception ignored) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}






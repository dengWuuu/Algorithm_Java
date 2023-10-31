package CF.灵茶试炼.Y_2023.other;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年06月05日 19:34
 */
class CF_414_B {
    int MOD = (int) 1e9 + 7;

    public void solve() {
        Kattio io = new Kattio();
        int u = io.nextInt(), n = io.nextInt();
        long ans = 0;
        long[][] dp = new long[n][u + 1];

        for (int i = 1; i <= u; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= u; j++) {
                dp[i][j] += dp[i - 1][j];
                for (int k = j * 2; k <= u; k += j) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD;
                }
            }
        }
        for (int i = 1; i <= u; i++) {
            ans = (ans + dp[n - 1][i]) % MOD;
        }

        io.println(ans);
        io.flush();
        io.close();
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

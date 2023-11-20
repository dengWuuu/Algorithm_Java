package CF.灵茶试炼.Y_2023.M_11;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年11月20日 15:58
 */
// https://codeforces.com/problemset/problem/804/B
class Main {
    public static void main(String[] args) {
        CF_804_B cf804B = new CF_804_B();
        cf804B.solve();
    }
}

public class CF_804_B {
    int MOD = (int) (1e9 + 7);

    public void solve() {
        Kattio io = new Kattio();
        String s = io.next();
        long ans = 0;
        long cntB = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'b') {
                cntB++;
                continue;
            }
            // 不然就是a
            ans += cntB;
            ans %= MOD;
            cntB *= 2;
            cntB %= MOD;
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

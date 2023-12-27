package codeforce.tea.Y_2023.M_12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年12月16日 16:13
 */
public class CF_1861_D {
    public void solve() {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while (t-- > 0) {
            int n = io.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            int ans = 0;
            int[] suf = new int[n + 2];
            for (int i = n - 2; i >= 0; i--) {
                suf[i] = suf[i + 1];
                if (a[i] >= a[i + 1]) {
                    suf[i]++;
                }
            }
            ans = suf[0];
            int pre = 1;
            for (int i = 1; i < n; i++) {
                ans = Math.min(ans, pre + suf[i]);
                if (a[i] >= a[i - 1]) {
                    pre++;
                }
            }
            ans = Math.min(pre, ans);
            io.println(ans);
        }
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

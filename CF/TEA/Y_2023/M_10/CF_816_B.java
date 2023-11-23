package CF.TEA.Y_2023.M_10;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年11月06日 15:36
 */
// https://codeforces.com/problemset/problem/816/B
public class CF_816_B {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt(), k = io.nextInt(), q = io.nextInt();
        int[] cnt = new int[(int) (2e5 + 10)];
        // 差分数组维护数字个数
        for (int i = 0; i < n; i++) {
            cnt[io.nextInt()]++;
            cnt[io.nextInt() + 1]--;
        }
        int origin = 0;
        int[] pre = new int[(int) (2e5 + 10)];
        for (int i = 0; i < (int) (2e5 + 1); i++) {
            origin += cnt[i];
            pre[i + 1] = pre[i];
            if (origin >= k) {
                pre[i + 1]++;
            }
        }
        for (int i = 0; i < q; i++) {
            int a = io.nextInt(), b = io.nextInt();
            System.out.println(pre[b + 1] - pre[a]);
        }


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

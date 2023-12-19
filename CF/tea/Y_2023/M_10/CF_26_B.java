package CF.tea.Y_2023.M_10;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年10月31日 17:39
 * https://codeforces.com/problemset/problem/26/B
 */
public class CF_26_B {
    public void solve() {
        Kattio io = new Kattio();
        String str = io.next();
        int l = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                l++;
            } else {
                if (l > 0) {
                    l--;
                    ans += 2;
                }
            }
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






package codeforce.tea.Y_2023.other;

import java.io.*;
import java.util.*;

/**
 * @author Wu
 * @date 2023年05月02日 11:01
 */
public class CF_1256_D {

    public static void solve() {
        Kattio io = new Kattio();
        int q = io.nextInt();

        while (q-- > 0) {
            int n = io.nextInt();
            long k = io.nextLong();
            String str = io.next();
            int c0 = 0, c1 = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '0') {
                    if (k < c1) {
                        io.println("0".repeat(c0) + "1".repeat(c1 - (int) k) + "0" + "1".repeat((int) k) + str.substring(i + 1));
                        flag = true;
                        break;
                    }
                    k -= c1;
                    c0++;
                } else c1++;
            }
            if (!flag) io.println("0".repeat(c0) + "1".repeat(c1));
        }

        io.flush();
        io.close();
    }

    public static void swap(int i, int j, char[] s) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
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

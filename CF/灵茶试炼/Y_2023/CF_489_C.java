package CF.灵茶试炼.Y_2023;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年05月01日 21:16
 */
//https://codeforces.com/problemset/problem/489/C
class CF_489_C {
    public void solve() {
        Kattio io = new Kattio();
        int m = io.nextInt(), s = io.nextInt();

        if (m * 9 < s || (s == 0 && m != 1)) {
            io.println(-1 + " " + -1);
            io.flush();
            io.close();
        }

        char[] min = new char[m];
        Arrays.fill(min, '0');
        min[0] = '1';
        int cnt = 1;
        //find min
        for (int i = m - 1; i >= 0; i--) {
            if (s - cnt > 9) {
                min[i] = '9';
                cnt += 9;
            } else {
                if (min[i] == '0') min[i] = (char) (s - cnt + '0');
                else min[i] = (char) (s - cnt + '0' + 1);
                break;
            }
        }
        //find max
        cnt = 0;
        char[] max = new char[m];
        Arrays.fill(max, '0');
        for (int i = 0; i < m; i++) {
            if (s - cnt > 9) {
                max[i] = '9';
                cnt += 9;
            } else {
                max[i] = (char) (s - cnt + '0');
                break;
            }
        }
        io.print(String.valueOf(min) + " " + String.valueOf(max));
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

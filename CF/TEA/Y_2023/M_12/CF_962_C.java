package CF.TEA.Y_2023.M_12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年12月19日 12:09
 */
public class CF_962_C {
    int max = Integer.MAX_VALUE / 2;
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int ans = dfs(n);
        if (ans >= max) io.println(-1);
        else io.println(ans);
        io.flush();
        io.close();
    }

    public int dfs(int num) {
        if (check(num)) return 0;
        if (num < 10) return max;
        String s = String.valueOf(num);
        int ans = max;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 || s.charAt(i + 1) != '0') {
                int deleteNum = Integer.parseInt(s.substring(0, i) + s.substring(i + 1));
                ans = Math.min(ans, dfs(deleteNum));
            }
        }
        return ans + 1;
    }

    public boolean check(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
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

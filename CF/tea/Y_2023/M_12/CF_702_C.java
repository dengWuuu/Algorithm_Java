package CF.tea.Y_2023.M_12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年12月19日 13:39
 */
class Main {
    public static void main(String[] args) {
        CF_702_C solution = new CF_702_C();
        solution.solve();
    }
}

public class CF_702_C {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt(), m = io.nextInt();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = io.nextInt();
        }


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

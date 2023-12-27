package codeforce.tea.Y_2023.M_11;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年11月23日 16:09
 */

class Main {
    public static void main(String[] args) {
        CF_534_C cf534C = new CF_534_C();
        cf534C.solve();
    }
}

public class CF_534_C {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        long s = io.nextLong();
        long sum = 0;
        int[] a = new int[n];
        s -= a.length;
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt() - 1;
            sum += a[i];
        }
        for (int i : a) {
            long up = Math.min(i, s);
            long down = Math.max(i - (sum - s), 0);
            io.print(i - up + down + " ");
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

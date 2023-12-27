package codeforce.tea.Y_2023.M_12;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年12月27日 16:04
 */

class Main {
    public static void main(String[] args) {
        new CF_923_B().solve();
    }
}

public class CF_923_B {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] a = new int[n], t = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = io.nextInt();
        }
        for (int i = 0; i < t.length; i++) {
            t[i] = io.nextInt();
        }
        long ans, sum = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(sum + a[i]);
            ans = 0;
            while (!q.isEmpty() && q.peek() <= sum + t[i]) {
                ans += q.poll() - sum;
            }
            ans += (long) q.size() * t[i];
            io.print(ans + " ");
            sum += t[i];
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

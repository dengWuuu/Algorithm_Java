package codeforce.tea.Y_2023.M_10;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年10月31日 17:48
 */
public class CF_569_B {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                arr[i] = -arr[i] - 1;
            }
        }
        // 找到最小的那个数 变回正数
        if (n % 2 != 0) {
            int idx = -1, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    idx = i;
                }
            }
            arr[idx] = -arr[idx] - 1;
        }


        for (int j : arr) {
            io.print(j + " ");
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

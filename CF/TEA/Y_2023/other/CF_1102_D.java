package CF.TEA.Y_2023.other;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年06月01日 16:59
 */

class CF_1102_D {
    public static void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        String s = io.next();

        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - '0']++;
        }
        char[] a = s.toCharArray();
        int average = n / 3;

        for (int i = 0; i < n; i++) {
            int idx = a[i] - '0';
            if (cnt[idx] > average) {
                for (int j = 0; j < idx; j++) {
                    if (cnt[j] < average) {
                        cnt[j]++;
                        cnt[idx]--;
                        a[i] = (char) (j + '0');
                        break;
                    }
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int idx = a[i] - '0';
            if (cnt[idx] > average) {
                for (int j = 2; j > idx; j--) {
                    if (cnt[j] < average) {
                        cnt[j]++;
                        cnt[idx]--;
                        a[i] = (char) (j + '0');
                        break;
                    }
                }
            }
        }

        io.println(String.valueOf(a));
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

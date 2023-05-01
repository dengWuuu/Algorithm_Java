package 笔试.携程真题.二三三数;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月03日 23:15
 */
//http://www.codefun2000.com/p/P1012
public class Main {
    //258888888888863
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        for (int i = 0; i < t; i++) {
            long l = io.nextLong();
            if (l % 233 != 0) io.println(-1);
            else {
                int ans = 0;
                l /= 233;
                while (l != 0) {
                    ans += l % 10;
                    l /= 10;
                }
                io.println(ans);
            }
        }
        io.flush();
        io.close();
    }

    public static class Kattio extends PrintWriter {
        private BufferedReader r;
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
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }

        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
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

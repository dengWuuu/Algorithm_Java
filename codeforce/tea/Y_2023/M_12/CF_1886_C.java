package codeforce.tea.Y_2023.M_12;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年12月13日 16:08
 */
// https://codeforces.com/contest/1886/problem/C
public class CF_1886_C {

    public void solve() {
        Kattio io = new Kattio();
        int T = io.nextInt();
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        while (T-- > 0) {
            String s = io.next();
            long pos = io.nextLong();
            int n = s.length();
            // 找到最后的字母
            while (pos - n > 0) {
                pos -= n;
                n--;
            }
            int deleteCnt = s.length() - n;
            for (int i = 0; i < s.length(); i++) {
                if (deque.isEmpty() || deque.peekLast() <= s.charAt(i)) {
                    deque.addLast(s.charAt(i));
                    continue;
                }
                while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && deleteCnt > 0) {
                    deque.pollLast();
                    deleteCnt--;
                }
                deque.addLast(s.charAt(i));
            }
            for (int i = 0; i < deleteCnt; i++) {
                deque.pollLast();
            }
            sb.append(deque.toArray()[(int) (pos - 1)]);
            deque.clear();
        }
        io.println(sb);
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

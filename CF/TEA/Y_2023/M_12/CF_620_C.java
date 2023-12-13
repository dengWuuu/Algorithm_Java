package CF.TEA.Y_2023.M_12;

import java.io.*;
import java.util.*;

/**
 * @author Wu
 * @date 2023年12月13日 15:56
 */
// https://codeforces.com/problemset/problem/620/C
public class CF_620_C {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = io.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        List<int[]> ans = new ArrayList<>();
        int l = 0;
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {
                ans.add(new int[]{l, i});
                l = i + 1;
                set.clear();
                continue;
            }
            set.add(a[i]);
        }
        // 尾巴那个要囊括进去
        if (!ans.isEmpty() && ans.get(ans.size() - 1)[1] != a.length - 1) {
            ans.get(ans.size() - 1)[1] = a.length - 1;
        }

        if (set.size() == a.length) {
            io.println(-1);
        } else {
            io.println(ans.size());
            for (int[] an : ans) {
                io.println(an[0] + 1 + " " + (an[1] + 1));
            }
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

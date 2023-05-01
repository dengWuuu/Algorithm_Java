package template_practice.树状数组;

import java.util.*;
import java.io.*;

/**
 * @author Wu
 * @date 2023年05月01日 21:41
 */
//https://codeforces.com/problemset/problem/369/E
//TODO: 技巧树状数组可以解决的

class Main {
    public static void main(String[] args) {
        CF_369_E.solve();
    }
}

class BIT_CF_369_E {
    private final int[] tree;

    public BIT_CF_369_E(int n) {
        tree = new int[n];
    }

    // 将下标 i 上的数加一
    public void inc(int i) {
        while (i < tree.length) {
            ++tree[i];
            i += i & -i;
        }
    }

    // 返回闭区间 [1, i] 的元素和
    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x &= x - 1;
        }
        return res;
    }

    // 返回闭区间 [left, right] 的元素和
    public int query(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}

class CF_369_E {
    public static void solve() {
        Kattio io = new Kattio();

        int n = io.nextInt(), m = io.nextInt();
        int[][] seg = new int[n][3];
        for (int i = 0; i < n; i++) {
            seg[i][0] = io.nextInt();
            seg[i][1] = io.nextInt();
            seg[i][2] = -1;
        }
        int[] ans = new int[m];
        Arrays.fill(ans, n);
        int[] q = new int[m];
        int pre = 0;
        for (int i = 0; i < q.length; i++) {
            int cnt = io.nextInt();
            for (int j = 0; j < cnt; j++) {
                int p = io.nextInt();

            }
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



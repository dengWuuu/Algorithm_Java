package template.快速幂;

/**
 * @author Wu
 * @date 2023年01月29日 13:10
 */
public class Solution {
    long MOD = (long) (1e9 + 7);

    public long pow3(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }

    public long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            b >>= 1;
        }
        return ans;
    }
}

package template.Math;

import org.junit.Test;

/**
 * @author Wu
 * @date 2023年09月23日 16:50
 * @email dengwu.wu@foxmail.com
 */
public class TestMain {

    @Test
    public void TestPow() {
        POW pow = new POW();

        // 测试逆元
        System.out.println((9 * pow.qpow(2L, (long) 1e9 + 7)) % (1e9 + 7));
    }
}

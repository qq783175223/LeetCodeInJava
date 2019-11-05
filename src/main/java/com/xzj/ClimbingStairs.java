package com.xzj;

/**
 * Create by xuzhijun.online on 2019/11/4.
 */
public class ClimbingStairs {
    /**
     * 超时
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}

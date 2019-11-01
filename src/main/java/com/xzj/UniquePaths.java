package com.xzj;

/**
 * Create by xuzhijun.online on 2019/11/1.
 */
public class UniquePaths {
    /**
     * 递归为何如此费时
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
    }

    public static int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(uniquePaths(51, 9));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        System.out.println(uniquePaths2(51, 9));
        System.out.println((System.currentTimeMillis() - end) + "ms");
    }
}

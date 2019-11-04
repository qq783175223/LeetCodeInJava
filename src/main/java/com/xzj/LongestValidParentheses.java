package com.xzj;

import java.util.Arrays;

/**
 * Create by xuzhijun.online on 2019/11/3.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses1("(()())"));
    }

    /**
     * 时间复杂度： O(n)。遍历整个字符串一次，就可以将 dp 数组求出来。
     * 空间复杂度： O(n) 。需要一个大小为 n 的 dp 数组。
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i == 1) ? 2 : dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 时间复杂度： O(n) 。遍历两遍字符串。
     * 空间复杂度： O(1) 。仅有两个额外的变量 leftCount 和 rightCount 。
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int tmp, max = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (rightCount > leftCount) {
                rightCount = 0;
                leftCount = 0;
            } else if (rightCount == leftCount) {
                tmp = rightCount * 2;
                max = max > tmp ? max : tmp;
            }
        }
        tmp = 0;
        leftCount = 0;
        rightCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (rightCount < leftCount) {
                rightCount = 0;
                leftCount = 0;
            } else if (rightCount == leftCount) {
                tmp = rightCount * 2;
                max = max > tmp ? max : tmp;
            }
        }
        return max;
    }
}

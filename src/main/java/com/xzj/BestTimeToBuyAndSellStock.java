package com.xzj;

/**
 * Create by xuzhijun.online on 2019/11/5.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int length = prices.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }
}

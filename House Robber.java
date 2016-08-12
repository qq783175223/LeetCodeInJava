
/**
*http://www.meetqun.com/thread-8777-1-1.html
*/

public class Solution {
    public int rob(int[] nums) {
        int take=0;
        int nonTake=0;
        int maxProfit=0;
        for(int i=0;i<nums.length;i++){
            take=nonTake+nums[i];//偷
            nonTake=maxProfit;//不偷
            maxProfit=Math.max(take,nonTake);//最大利润
        }
        return maxProfit;
    }
}
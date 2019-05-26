package src.main.java.com.xzj;

//时间复杂度O(N)空间复杂度O(1);
//如果用一个数组保存右边的最大值,则更好理解这个算法,只是空间复杂度为O(N)
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int value = 0;
        int leftMax = height[0];//遍历到height[i]时height[i]左边最大值
        int rightMax = height[height.length - 1];//遍历到height[i]时height[i]右边最大值
        for (int i = 1, j = height.length - 2; i <= j; ) {
            if (leftMax > rightMax) {
                if (rightMax - height[j] > 0) {
                    value += rightMax - height[j];
                } else {
                    rightMax = height[j];
                }
                j--;
            } else {
                if (leftMax - height[i] > 0) {
                    value += leftMax - height[i];
                } else {
                    leftMax = height[i];
                }
                i++;
            }
        }
        return value;
    }
}
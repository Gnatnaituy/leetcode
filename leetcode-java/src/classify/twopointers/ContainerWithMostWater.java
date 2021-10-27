package classify.twopointers;

/**
 * @author yutiantang
 * @create 2021/3/28 4:23 PM
 */
public class ContainerWithMostWater {

    /**
     * 6ms  21.25%
     * 52MB 13.36%
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max  = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    /**
     * 优化， 减少max的计算次数
     * 2ms      99.39%
     * 51.8MB   24.03%
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max  = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                int lh = height[left];
                while (left < right && height[left] <= lh) {
                    left++;
                }
            } else {
                int rh = height[right];
                while (right > left && height[right] <= rh) {
                    right--;
                }
            }
        }

        return max;
    }
}

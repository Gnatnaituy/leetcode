package classify.greedy.medium;

/**
 * @author yutiantang
 * @create 2021/3/28 4:23 PM
 */
public class ContainerWithMostWater {

    /**
     * 6ms  21.25%
     * 52MB 13.36%
     * 可容纳水的高度由两板中的 短板 决定
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
     * 2ms      99.39%
     * 51.8MB   24.03%
     * 优化， 减少max的计算次数
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

    /**
     * 3ms      92.18%
     * 51.6MB   32.98%
     */
    public int maxArea3(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = Math.max(res, (j - i) * 
                height[i] < height[j] ? height[i++] : height[j--]);
        }

        return res;
    }
}

package completefifties.l0000;

/**
 * 11. Container with Most Water
 */

public class ContainerWithMostWater {

    // 690ms 3.33%
//    private int maxArea(int[] height) {
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = 0; j < height.length; j++) {
//                int area = Math.min(height[i], height[j]) * (j - i);
//                max = max > area ? max : area;
//            }
//        }
//
//        return max;
//    }
    
    // 10ms 69.35%
    private int maxArea(int[] height) {
        int max = 0;
        
        for(int i = 0, j = height.length - 1; i < j ; ){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        
        return max;
    }
}

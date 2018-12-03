package easy.ftwenty;


import java.util.Arrays;

/**
 * 475 Heaters
 *
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2,
 * and if we use the radius 1 standard, then all the houses can be warmed.
 *
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4.
 * We need to use radius 1 standard, then all the houses can be warmed.
 */

public class Heaters {

    private static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int startIndex = 0, maxN = 0;

        for (int house : houses) {
            int tempMin = Integer.MAX_VALUE;
            for (int j = startIndex; j < heaters.length; j++) {
                if (Math.abs(heaters[j] - house) <= tempMin) {
                    tempMin = Math.abs(heaters[j] - house);
                    startIndex = j;
                } else {
                    break;
                }
            }
            maxN = Math.max(maxN, tempMin);
        }

        return maxN;
    }
}

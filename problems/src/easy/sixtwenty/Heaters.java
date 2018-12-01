package easy.sixtwenty;

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
        if (houses.length == 0 || heaters.length == 0)
            return 0;

        int middle = 0;
        for (int i = 0; i < heaters.length - 1; i++)
            if (heaters[i + 1] - heaters[i] > middle)
                middle = heaters[i + 1] - heaters[i];

        if (houses[0] <= heaters[0]) {
            int start = heaters[0] - houses[0];
            if (houses[houses.length - 1] >= heaters[heaters.length - 1]) {
                int end = houses[houses.length - 1] - heaters[heaters.length - 1];
                return Math.max(Math.max(start, end), middle / 2);
            } else {
                return Math.max(start, middle / 2);
            }
        } else {
            if (houses[houses.length - 1] >= heaters[heaters.length - 1]) {
                int end = houses[houses.length - 1] - heaters[heaters.length - 1];
                return Math.max(end, middle / 2);
            } else {
                return middle / 2;
            }
        }
    }
}

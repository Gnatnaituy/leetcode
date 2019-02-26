package others.easy.ftwenty;

import java.util.HashMap;
import java.util.Map;

/**
 * 447 Number of Boomerangs
 *
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs.
 * You may assume that n will be at most 500 and coordinates of points are all in the range
 *  [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

public class NumberOfBoomerangs {

    private static int numberOfBoomerangs(int[][] points) {
        if (points.length < 3)
            return 0;

        int result = 0;
        Map<Integer, Integer> map;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = getDistancePower(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            result += getCountByPoint(map);
        }

        return result;
    }

    private static int getDistancePower(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] = b[1];
        return x * x + y * y;
    }

    private static int getCountByPoint(Map<Integer, Integer> map) {
        int result = 0;
        for (Integer value : map.values()) {
            if (value > 1)
                result += value * (value - 1);
        }
        return result;
    }
}

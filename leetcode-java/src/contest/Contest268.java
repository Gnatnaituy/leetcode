package contest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tiantang
 * @Date 2021/11/21
 */
public class Contest268 {

    public int maxDistance(int[] colors) {
        int n = colors.length - 1;
        while (colors[n] == colors[0]) {
            n--;
        }

        int m = 0;
        while (colors[m] == colors[colors.length - 1]) {
            m++;
        }

        return Math.max(n, colors.length - m - 1);
    }

    public static int wateringPlants(int[] plants, int capacity) {
        int res = 0, cur = capacity;
        for (int i = 0; i < plants.length;) {
            if (plants[i] <= cur) {
                res += 1;
                cur -= plants[i];
                i++;
            } else {
                res += i + i;
                cur = capacity;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        wateringPlants(new int[]{1,1,1,4,2,3}, 5);
    }
}

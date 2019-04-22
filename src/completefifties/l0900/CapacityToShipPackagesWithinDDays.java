package completefifties.l0900;

public class CapacityToShipPackagesWithinDDays {

    /**
     * 二分法
     */
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        int l = max, r = sum;
        int ans = 0x3f3f3f3f;
        while (l <= r) {
            int mid = (l + r) / 2;
            int d = 0;
            int tmp = 0;
            for (int weight : weights) {
                tmp += weight;
                if (tmp > mid) {
                    tmp = weight;
                    d++;
                }
            }
            if (tmp > 0) {
                d++;
            }
            if (d <= D) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /*
     * 贪心算法
     */

}

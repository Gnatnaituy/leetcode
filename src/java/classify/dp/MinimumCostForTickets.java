package java.classify.dp;

public class MinimumCostForTickets {

    /**
     * 1ms 97.29%
     * 33.9MB 100.00%
     */
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] traveled = new boolean[366];
        for (int day : days) traveled[day] = true;

        int[] minCost = new int[366];
        minCost[0] = 0;
        for (int day = 1; day < 366; day++) {
            if (!traveled[day]) {
                minCost[day] = minCost[day - 1];
                continue;
            }

            int min;
            // 买1天的票
            min = minCost[day - 1] + costs[0];
            // 买7天的票
            min = Math.min(min, minCost[Math.max(0, day - 7)] + costs[1]);
            // 买30天的票
            min = Math.min(min, minCost[Math.max(0, day - 30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[365];
    }
}

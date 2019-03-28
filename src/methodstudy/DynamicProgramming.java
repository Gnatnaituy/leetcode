package methodstudy;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    /**
     * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶
     * 要求用程序来求出一共有多少种走法
     * <p>
     * 解法一: 递归求解
     * 时间和空间复杂度都是指数级增长
     */
    private static int clumbStairs(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return clumbStairs(n - 1) + clumbStairs(n - 2);
    }

    /**
     * 解法二: 备忘录
     * 用一个HashMap保存n个台阶的走法, 避免重复计算
     */
    private static HashMap<Integer, Integer> map;

    private static int clumbStairsWithMemorandum(int n, HashMap<Integer, Integer> map) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        else {
            int value = clumbStairsWithMemorandum(n - 1, map) + clumbStairsWithMemorandum(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 解法三: 动态规划
     * 到达这一个阶梯的走法只与前两阶台阶相关
     */
    private static int clumbStairsWithDP(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }


    /**
     * 国王和金矿
     * <p>
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同
     * 金/人数: 500/5 400/5 350/3 300/4 200/3 参与挖矿工人的总数是10人
     * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿
     * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     * <p>
     * 方法一: 排列组合
     * 指数级的时间复杂度O(2^N), 不做分析
     */
    private static final int WORKER_NUM = 10;   // 工人数量
    private static final int GOLD_MINE = 5;     // 金矿数量
    private static final int[] GV = new int[]{500, 400, 300, 350, 200}; // 各金矿的含金量
    private static final int[] GW = new int[]{5, 5, 4, 3, 3};           // 开采各金矿需要的工人数

    /**
     * 方法二: 简单递归
     *
     * @param g gold mine number
     * @param w worker number
     */
    private static int mining(int g, int w) {
        if (g <= 1 && w < GW[0])
            return 0;
        if (g == 1 && w >= GW[0])
            return GV[0];
        if (g > 1 && w < GW[g - 1])
            return mining(g - 1, w);
        else
            return Math.max(mining(g - 1, w), mining(g - 1, w - GW[g - 1]) + GV[g - 1]);
    }

    /**
     * 方法三: 备忘录算法
     */
    private static Map<Integer, Integer> mapGoldWorker = new HashMap<>();

    private static int miningWithMemorandum(int g, int w) {
        if (g <= 1 && w < GW[0])
            return 0;
        if (g == 1 && w >= GW[0])
            return GV[0];
        else if (g > 1 && w < GW[g - 1]) {
            if (mapGoldWorker.containsKey(g)) {
                return mapGoldWorker.get(g);
            } else {
                int value = mining(g - 1, w);
                mapGoldWorker.put(g, value);
                return value;
            }
        } else {
            if (mapGoldWorker.containsKey(g)) {
                return mapGoldWorker.get(g);
            } else {
                int value = Math.max(mining(g - 1, w), mining(g - 1, w - GW[g - 1]) + GV[g - 1]);
                mapGoldWorker.put(g, value);
                return value;
            }
        }
    }

    /**
     * 方法四: 动态规划
     */
    private static int miningWithDP(int g, int w) {
        int[] preRes = new int[w + 1];
        int[] res = new int[w + 1];

        for (int i = 0; i <= w; i++) {
            preRes[i] = i < GW[0] ? 0 : GV[0];
        }

        for (int i = 1; i < g; i++) {        // 金矿数量, 注意从1(即第二座金矿)开始->(上面第一座金矿已经被挖过了)
            for (int j = 0; j <= w; j++) {   // 工人数量
                res[j] = j < GW[i] ? preRes[j] : Math.max(preRes[j], preRes[j - GW[i]] + GV[i]);
            }
            preRes = res.clone();
        }

        return res[w];
    }


    public static void main(String[] args) {
        System.out.println(mining(GOLD_MINE, WORKER_NUM));
        System.out.println(miningWithMemorandum(GOLD_MINE, WORKER_NUM));
        System.out.println(miningWithDP(GOLD_MINE, WORKER_NUM));
    }
}

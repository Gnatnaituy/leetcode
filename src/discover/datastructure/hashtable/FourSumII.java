package discover.datastructure.hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * 454 四数相加II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500
 * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1
 */
public class FourSumII {

    /**
     * 177ms 68.27%
     */
    public int fourSunCount(int[] A, int[] B, int[] C, int[] D) {
        // 查找表法，先将 C 和 D 的所有组合的和存进查找表中
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                int s = c + d;
                map.put(s, map.getOrDefault(s, 0) + 1);

            }
        }
        int res = 0;
        // 利用 A 和 B 的所有组合进行查找
        for (int a : A) {
            for (int b : B) {
                int d = 0 - a - b;
                res += map.getOrDefault(d, 0);
            }
        }

        return res;
    }
}

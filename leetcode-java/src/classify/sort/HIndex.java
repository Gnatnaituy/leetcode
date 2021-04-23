package classify.sort;

import java.util.Arrays;

/**
 * @author yutiantang
 * @create 2021/4/23 23:06
 */
public class HIndex {

    /**
     * 1ms      87.21%
     * 36.5MB   25.06%
     * 官方题解 排序
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
        Arrays.sort(citations);
        // 线性扫描找出最大的 i
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }

        return i;
    }

    /**
     * 0ms      100.00%
     * 36.1MB   91.87%
     * 官方题解 计数
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        // 计数
        for (int c: citations) {
            papers[Math.min(n, c)]++;
        }

        // 找出最大的 k
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {
            k--;
        }

        return k;
    }
}

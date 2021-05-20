package classify.dp;

/**
 * @author yutiantang
 * @create 2021/5/18 23:33
 */
public class TheMasseuse {

    /**
     * 0ms      100.00%
     * 35.8MB   62.81%
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        int choose = 0, notChoose = 0, preChoose = 0;
        for (int num : nums) {
            preChoose = choose;
            choose = notChoose + num;
            notChoose = Math.max(notChoose, preChoose);
        }

        return Math.max(choose, notChoose);
    }
}

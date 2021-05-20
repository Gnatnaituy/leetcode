package classify.greedy;

/**
 * @author yutiantang
 * @create 2021/5/20 23:00
 */
public class CouplesHoldingHands {

    /**
     * 0ms      100.00%
     * 35.7MB   89.02%
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length - 1; i += 2) {
            if (!isCouple(row, i, i + 1)) {
                findCouple(row, i);
                res++;
            }
        }

        return res;
    }

    private boolean isCouple(int[] row, int i, int j) {
        return Math.abs(row[i] - row[j]) == 1 && ((row[i] + row[j]) / 2) % 2 == 0;
    }

    private void findCouple(int[] row, int i) {
        for (int j = i + 1; j < row.length; j++) {
            if (isCouple(row, i, j)) {
                swap(row, i + 1, j);
            }
        }
    }

    private void swap(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }

    /**
     * 0ms      100.00%
     * 35.7MB   86.37%
     * @param row
     * @return
     */
    public int minSwapsCouples2(int[] row) {
        int res = 0;
        int[] memo = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            memo[row[i]] = i;
        }

        for (int i = 0; i < row.length - 1; i += 2) {
            if (Math.abs(row[i] - row[i + 1]) != 1 || ((row[i] + row[i + 1]) / 2) % 2 != 0) {
                int right = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
                swap(row, memo, i + 1, memo[right]);
                res++;
            }
        }

        return res;
    }

    private void swap(int[] row, int[] memo, int i, int j) {
        memo[row[i]] = j;
        memo[row[j]] = i;
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }
}

package java.completefifties.l0500;

import java.util.List;

public class BeautifulArrangement {
    private List<List<Integer>> res;
    private int count = 0;

    /**
     * 313ms 7.00%
     * 33.1MB 63.89%
     */
    public int countArrangement(int N) {
//        res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//
//        helper(list, N);
//
//        return res.size();
        boolean[] flag = new boolean[N + 1]; // 从下标为1开始, 第0个不用
        helper2(flag, 1, N);

        return count;
    }

    private void helper(List<Integer> list, int N) {
        if (list.size() == N) {
            res.add(list);
        }

        for (int i = 1; i <= N; i++) {
            if (!list.contains(i) && (i % (list.size() + 1) == 0 || (list.size() + 1) % i == 0)) {
                list.add(i);
                helper(list, N);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 87ms 71.00%
     * 32.5MB 88.89%
     * 利用数组优化
     */
    private void helper2(boolean[] flag, int pos, int N) {
        if (pos == N + 1) {     // 最后一位也要判断是否满足条件 所以是 pos == N + 1 而不是 pos == N
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!flag[i] && (i % pos == 0 || pos % i == 0)) {
                flag[i] = true;
                helper2(flag, pos + 1, N);
                flag[i] = false;
            }
        }
    }

    /**
     * 6ms
     */
    public int countArrangement2(int N) {
        if (N == 0) return 0;
        int[] nums = new int[N + 1];
        for (int i = 0; i <= N; i++) nums[i] = i;
        helper(nums, N);
        return count;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void helper(int[] nums, int start) {
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0)
                helper(nums, start - 1);
            swap(nums, i, start);
        }
    }
}

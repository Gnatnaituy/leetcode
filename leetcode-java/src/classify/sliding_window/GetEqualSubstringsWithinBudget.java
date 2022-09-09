package classify.sliding_window;

public class GetEqualSubstringsWithinBudget {

    /**
     * 3ms      99.51%      O(n)
     * 41.4MB   65.08%      O(n)
     * 滑动窗口
     */
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] diff = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            diff[i] = Math.abs(ss[i] - tt[i]);
        }

        int left = 0, right = 0, res = 0, cost = 0;
        while (right < diff.length) {
            cost += diff[right++];
            while (cost > maxCost && left < right) {
                cost -= diff[left++];
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    /** 
     * 前缀和+二分查找 官方题解
     */
    public int equalSubstring2(String s, String t, int maxCost) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] prefixSum = new int[ss.length + 1];
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + Math.abs(ss[i] - tt[i]);
        }

        int maxLength = 0;
        for (int i = 1; i <= prefixSum.length; i++) {
            int start = check(prefixSum, i, prefixSum[i] - maxCost);
            maxLength = Math.max(maxLength, i - start);
        }

        return maxLength;
    }

    private int check(int[] prefixSum, int endIndex, int maxCost) {
        int low = 0, high = endIndex;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] < maxCost) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget e = new GetEqualSubstringsWithinBudget();
        String s = "aaaa";
        String t = "bcde";
        System.out.println(e.equalSubstring2(s, t, 1));
    }
}
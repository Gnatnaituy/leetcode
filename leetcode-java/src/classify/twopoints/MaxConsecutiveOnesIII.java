package classify.twopoints;

/**
 * @author yutiantang
 * @create 2021/3/24 9:59 AM
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, countOneInWindow = 0;
        while (right < A.length) {
            if (A[right] == 1) {
                countOneInWindow++;
            }
            if (right - left + 1 > countOneInWindow + K) {
                if(A[left] == 1) {
                    countOneInWindow--;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}

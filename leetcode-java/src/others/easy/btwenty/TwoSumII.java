package others.easy.btwenty;


/**
 * 167 Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class TwoSumII {

    /**
     * 2ms
     */
    private static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;

        for (int i = numbers.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] + numbers[j] < target)
                    continue;
                if (numbers[i] + numbers[j] == target)
                    return new int[]{j + 1, i + 1};
                else break;
            }
        }

        return null;
    }

    /**
     * 1ms
     */
    public int[] twoSum2(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1};
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                high--;
            }
        }

        return null;
    }
}

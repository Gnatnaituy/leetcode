package classify.twopointers;

public class TwoSumII {

    /**
     * 0ms 100.00%
     * 36.5MB 67.26%
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    /**
     * 1ms      98.92%
     * 43.8MB   90.26%
     */
    public int[] twoSum2(int[] numbers, int target) {
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
}

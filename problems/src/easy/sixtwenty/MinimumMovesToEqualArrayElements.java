package easy.sixtwenty;


/**
 * 453 Minimum Moves to Equal Array Elements
 *
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

public class MinimumMovesToEqualArrayElements {

    /**
     * Reverse Thinking
     * Every move makes all the n-1 elements plus 1, equals every move makes the max sub 1
     * Therefore the minimum move steps is the sum of elements sub the sum of the min elements
     *
     * @param nums int
     * @return int
     */
    private static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            if (num < min)
                min = num;
        }
        return sum - min * nums.length;
    }
}

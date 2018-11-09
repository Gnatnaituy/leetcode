package easy.twotwenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 Pascal's Triangle II
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangleII {

    private static List<Integer> getRow(int rowIndex) {

        List<Integer> indexRow = new ArrayList<>(33);

        indexRow.add(1);
        if (rowIndex == 0)
            return indexRow;

        indexRow.add(1);
        if (rowIndex == 1)
            return indexRow;

        iterate(indexRow, rowIndex);

        return indexRow;
    }

    private static void iterate(List<Integer> indexRow, int time) {
        if (time < 2)
            return;
        while (time > 1) {
            for (int i = indexRow.size() - 1; i > 0; i--) {
                indexRow.set(i, indexRow.get(i) + indexRow.get(i - 1));
            }
            indexRow.add(1);
            time--;
        }
    }
}

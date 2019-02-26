package others.easy.btwenty;


import java.util.ArrayList;
import java.util.List;

/**
 * 118 Pascal's Triangle
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalsTriangle {

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowOne = new ArrayList<>();
        if (numRows == 0)
            return result;
        rowOne.add(1);
        result.add(rowOne);
        if (numRows == 1)
            return result;
        List<Integer> rowTwo = new ArrayList<>();
        rowTwo.add(1);
        rowTwo.add(1);
        result.add(rowTwo);
        if (numRows == 2)
            return result;
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            List<Integer> previous = result.get(i - 1);
            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                row.add(previous.get(j) + previous.get(j + 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}

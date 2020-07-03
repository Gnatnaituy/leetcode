package others.discover.algorithm.elementary.others;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 */
public class PascalsTriangle {

    /**
     * 1ms 95.26%
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;

        List<Integer> rowOne = new LinkedList<>();
        rowOne.add(1);
        res.add(rowOne);
        if (numRows == 1) return res;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> rowI = new LinkedList<>();
            int n = 0;
            while (n < i) {
                if (n == 0 || n == i - 1) {
                    rowI.add(1);
                } else {
                    rowI.add(res.get(i - 2).get(n - 1) + res.get(i - 2).get(n));
                }
                n++;
            }
            res.add(rowI);
        }

        return res;
    }

    /**
     * 0ms
     */
    public List<List<Integer>> generate2(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int[][] a = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                list.add(a[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}

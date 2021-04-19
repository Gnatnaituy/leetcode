package tools;

import java.util.Arrays;

/**
 * @author yutiantang
 * @create 2021/4/17 14:04
 */
public class ParseArray {

    public static int[] parseArray(String s) {
        s = s.substring(1, s.length() - 1);
        String[] digits = s.split(",");
        return Arrays.stream(digits).mapToInt(Integer::valueOf).toArray();
    }

    public static int[][] parseTwoDimensionalArray(String s) {
        s = s.substring(2, s.length() - 2);
        String[] pairs = s.split("],\\[");
        return Arrays.stream(pairs)
                .map(o -> o.split(","))
                .map(o -> new int[]{Integer.parseInt(o[0]), Integer.parseInt(o[1])})
                .toArray(int[][]::new);
    }
}

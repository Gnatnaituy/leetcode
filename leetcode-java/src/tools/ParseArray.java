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

    public static int[][] parse2CharArray(String s) {
        s = s.substring(2, s.length() - 2);
        String[] pairs = s.split("],\\[");
        return Arrays.stream(pairs)
                .map(o -> o.split(","))
                .map(o -> Arrays.stream(o).map(x -> x.toCharArray()[0]).mapToInt(x -> x).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
       int[][] a = parse2CharArray("[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
       int b = 0;
    }
}

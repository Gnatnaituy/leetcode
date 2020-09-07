package contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/9/5 22:27
 * @Description Double20200905
 */
public class Double20200905 {

    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            if (i == mat[i].length - i - 1) {
                res += mat[i][i];
            } else {
                res += mat[i][i] + mat[i][mat[i].length - i - 1];
            }
        }

        return res;
    }

    public int numWays(String s) {
        char[] arr = s.toCharArray();
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                indexs.add(i);
            }
        }
        if (indexs.size() % 3 != 0) return 0;
        if (indexs.size() == 0) {
            int res = 1;
            for (int i = 3; i < s.length(); i++) {
                res = (res + (i  - 1)) % 1000000007;
            }
            return res;
        }

        int size = indexs.size() / 3;
        List<Integer> gaps = new ArrayList<>(2);
        for (int i = 0 ; i < indexs.size() - 1; i++) {
            if ((i + 1) % size == 0) {
                gaps.add(indexs.get(i + 1) - indexs.get(i) - 1);
            }
        }

        return (int) (((long) (gaps.get(0) + 1) * (gaps.get(1) + 1)) % 1000000007);
    }

    public static void main(String[] args) {
        long a = ((long) 100000000 * 10000000) % 1000000007;
        System.out.println(a);
    }
}

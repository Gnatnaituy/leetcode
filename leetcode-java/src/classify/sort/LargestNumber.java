package classify.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/4/20 22:26
 */
public class LargestNumber {

    /**
     * 13ms     17.22%
     * 38ms     51.45%
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> numsString = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                // 防止 o1 + o2 > Integer.MAX_VALUE
                .sorted((o1, o2) -> (int) (Long.parseLong(o2 + o1) - Long.parseLong(o1 + o2)))
                .collect(Collectors.toList());

        // [0, 0, 0] 的结果为 0
        if (numsString.get(0).equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (String num: numsString) {
            res.append(num);
        }

        return res.toString();
    }

    /**
     * 4ms      96.18%
     * 36MB     99.51%
     *  官方题解 思路一样
     * @param nums
     * @return
     */
    public String largestNumber2(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }

        return ret.toString();
    }
}

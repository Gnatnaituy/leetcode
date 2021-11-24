package classify.greedy;

/**
 * @Author tiantang
 * @Date 2021/11/24
 */
public class IncreasingTripletSubsequence {

    /**
     * 2ms      80.18%
     * 79.3MB   5.06%
     * 贪婪算法
     * 保证 mid 在 min 后面, tmpMin 在 mid 后面
     *
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int min = nums[0], mid = Integer.MAX_VALUE, tmpMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num > mid) {
//                System.out.println("final min: " + min + " mid: " + mid + " tmpMin: " + tmpMin + " num: " + num);
                return true;
            }

            if (num == mid) {
                continue;
            }

            if (num > min) {
                mid = num;
            }

            if (num <= min) {
                if (num > tmpMin) {
                    min = tmpMin;
                    mid = num;
                    tmpMin = Integer.MAX_VALUE;
                }
                if (num < tmpMin) {
                    tmpMin = num;
                }
            }

//            System.out.println("min: " + min + " mid: " + mid + " tmpMin: " + tmpMin + " num: " + num);
        }

        return false;
    }

    /**
     * 大佬解法
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) return false;

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i > mid) return true;
            if (i <= min) min = i;
            else mid = i;
        }

        return false;
    }

    public static void main(String[] args) {
        increasingTriplet(new int[]{1, 5, 0, 4, 1, 3});
    }
}

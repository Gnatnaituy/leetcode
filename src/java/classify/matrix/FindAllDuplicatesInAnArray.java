package java.classify.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    /**
     * 22ms 27.63%
     * 47MB 98.45%
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    /**
     * 6ms 93.67%
     * 46.2MB 99.64%
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp  -1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }

        return res;
    }
}

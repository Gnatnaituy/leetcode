package classify.twopointers;

import tools.ParseArray;

public class RemoveDuplicatesFromSortedArray {

    /**
     * 0ms      100.00%
     * 43.4MB   5.29%
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray o = new RemoveDuplicatesFromSortedArray();
        System.out.println(o.removeDuplicates(ParseArray.parseArray("[1]")));
        System.out.println(o.removeDuplicates(ParseArray.parseArray("[1,1]")));
        System.out.println(o.removeDuplicates(ParseArray.parseArray("[1,2]")));
        System.out.println(o.removeDuplicates(ParseArray.parseArray("[1,1,2]")));
        System.out.println(o.removeDuplicates(ParseArray.parseArray("[1,1,2,2]")));
        System.out.println(o.removeDuplicates(ParseArray.parseArray("[1,1,2,2,3]")));
    }
}

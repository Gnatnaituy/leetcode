package java.others.easy.atwenty;

public class RemoveElement {

    private int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        int valCount = 0;

        for (int num : nums)
            if (num == val)
                valCount++;

        while (currentIndex < nums.length - valCount) {
            if (nums[currentIndex] == val) {
                for (int i = currentIndex; i < nums.length; i++) {
                    if (nums[i] != val) {
                        nums[currentIndex] = nums[i];
                        nums[i] = val;
                        break;
                    }
                }
            }
            currentIndex++;
        }

        return nums.length - valCount;
    }

    /**
     * 10ms
     * 快慢指针法
     */
    private int removeElement2(int[] nums, int val) {
            int fast = 0;
            int slow = 0;

            for (; fast < nums.length;) {
                if (nums[fast] == val) {
                    fast++;
                } else {
                    nums[slow++] = nums[fast++];
                }
            }

            return slow;
    }

    /**
     * 5ms
     * 快慢指针法更优雅的写法
     */
    public int removeElement3(int[] nums, int val) {
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}

package easy.onetwenty;

public class Ach_RemoveElement {

    private static int removeElement(int[] nums, int val) {
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

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,5,2,2,2};
        int a = removeElement(nums, 2);
        for (int i = 0; i < a; i++) {
            System.out.print(nums[i]);
        }
    }
}

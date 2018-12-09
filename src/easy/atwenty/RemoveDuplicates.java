package easy.atwenty;

public class RemoveDuplicates {

    private static int removeDuplicates(int[] nums) {

        int currentIndex = 1;

        switch (nums.length) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                int max = nums[nums.length - 1];
                int currentMax = nums[0];
                while (currentIndex < nums.length) {
                    if (nums[currentIndex] > currentMax) {
                        currentMax = nums[currentIndex];
                        currentIndex++;
                    } else if (nums[currentIndex] == max) {
                        return currentIndex;
                    } else {
                        int moveIndex = currentIndex;
                        while (nums[moveIndex] <= currentMax) {
                            moveIndex++;
                        }
                        if (nums[moveIndex] == max) {
                            nums[currentIndex] = max;
                            currentIndex++;
                            break;
                        } else {
                            nums[currentIndex] = nums[moveIndex];
                            currentMax = nums[moveIndex];
                            currentIndex++;
                        }
                    }
                }
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 5};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.print("\n");

        int a = removeDuplicates(nums);
        for (int i = 0; i < a; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.printf("\n%d\n%d",nums.length, a);
    }
}

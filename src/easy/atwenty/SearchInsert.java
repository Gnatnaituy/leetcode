package easy.atwenty;

public class SearchInsert {

    private static int searchInsert(int[] nums, int target) {

        int index = 0;

        if (nums[0] > target)
            index = 0;
        else if (nums[nums.length - 1] < target)
            index = nums.length;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    index = i;
                    break;
                } else if (nums[i] < target && nums[i + 1] > target) {
                    index = i + 1;
                    break;
                } else
                    index = nums.length;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int target = 0;
        int b = searchInsert(a, target);
        System.out.print(b);
    }
}

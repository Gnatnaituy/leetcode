package others;

import java.util.Arrays;

public class AddTwoNumbers {
	public static void main(String[] args) {
		int[] a = {2,6,5,8,7,9};
		int target = 13;
		int[] solution = twoSum(a, target);
		System.out.println(Arrays.toString(solution));
	}

    private static int[] twoSum(int[] nums, int target) {
    	int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
    return answer;    
    }
}
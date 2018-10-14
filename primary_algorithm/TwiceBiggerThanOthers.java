public class TwiceBiggerThanOthers {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,9};
		int biggest = nums[0];
		int secondBig = nums[0];
		int biggestIndex = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= secondBig * 2) {
				biggest = nums[i]
				biggestIndex = i;
			} else if (nums[i] > secondBig && nums[i] < secondBig * 2) {
				secondBig = nums[i];
			}
		}

		if (biggest >= 2 * secondBig) {
			System.out.println(biggestIndex);
		} else {
			System.out.println("-1");
		}
	}
}
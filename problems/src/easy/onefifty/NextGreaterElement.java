package easy.onefifty;

public class NextGreaterElement {


    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length - 1; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            res[i] = nums2[k];
                            break;
                        } else {
                            res[i] = -1;
                        }
                    }
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {5,4,3,2,1};
        int[] nums3 = nextGreaterElement(nums1, nums2);
        for (int aNums3 : nums3) {
            System.out.println(aNums3);
        }
    }
}
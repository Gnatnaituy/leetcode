package contest;

import tools.ParseArray;

import java.util.ArrayList;
import java.util.List;

public class Week284 {

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int maxLeft = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(Math.max(0, i - k), maxLeft + 1); j < i; j++) {
                    res.add(j);
                }
                res.add(i);
                maxLeft = i;
                for (int j = i + 1; j <= Math.min(i + k, nums.length - 1) && nums[j] != key; j++) {
                    res.add(j);
                    maxLeft = j;
                }
                i = maxLeft;
            }
        }

        return res;
    }

    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] matrix = new int[n][n];
        int res = 0;
        boolean add = true;

        for (int[] d : dig) {
            matrix[d[0]][d[1]] = 1;
        }

        for (int[] artifact : artifacts) {
            for (int row = artifact[0]; row <= artifact[2]; row++) {
                if (!add) {
                    break;
                }
                for (int col = artifact[1]; col <= artifact[3]; col++) {
                    if (matrix[row][col] == 0) {
                        add = false;
                        break;
                    }
                }
            }
            res += add ? 1 : 0;
            add = true;
        }

        return res;
    }

    public static int maximumTop(int[] nums, int k) {
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max1Index = 0;

        int i = 0;
        for (; i < nums.length && i < k; i++) {
            max2 = Math.max(max2, Math.min(max1, nums[i]));
            if (nums[i] > max1) {
                max1Index = i;
                max1 = nums[i];
            }
        }

        if (k < nums.length) {
            return max1Index == i - 1 ? Math.max(max2, nums[i]) : Math.max(max1, nums[i]);
        } else if (k == nums.length) {
            return max1Index == nums.length - 1 ? max2 : max1;
        } else {
            return max1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{1,1000,1,1000}, 1, 1));
        System.out.println(digArtifacts(2,
                ParseArray.parse2IntegerArray("[[0,0,0,0],[0,1,1,1]]"),
                ParseArray.parse2IntegerArray("[[0,0],[0,1],[1,1]]")));
        System.out.println(maximumTop(ParseArray.parseArray("[99,95,68,24,18]"), 4));
    }
}

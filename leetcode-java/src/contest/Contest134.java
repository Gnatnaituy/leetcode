package contest;

import java.util.Arrays;

public class Contest134 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] poses = new int[]{a, b, c};
        Arrays.sort(poses);

        int left = poses[1] - poses[0] - 1;
        int right = poses[2] - poses[1] - 1;

        if (left == 0 && right == 0) return new int[]{0, 0};
        if ((left == 0 && right == 1) || (left == 1 && right == 0)) return new int[]{1, 1};
        if (left == 0 && right > 1) return new int[]{1, right};
        if (left > 1 && right == 0) return new int[]{1, left};
        if (left == 1 && right == 1) return new int[]{1, 2};
        if (left == 1 && right > 1) return new int[]{1, right + 1};
        if (left > 1 && right == 1) return new int[]{1, left + 1};
        return new int[]{2, left + right};
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int max = 0;
        backTrack(A, B, 0, 0, 0, max);
        return max;
    }

    private void backTrack(int[] A, int[] B, int start1, int start2, int temp, int max) {
        if (start1 == A.length || start2 == B.length) {
            max = Math.max(max, temp);
        }

        for (int i = start1; i < A.length; i++) {
            for (int j = start2; j < B.length; j++) {
                if (A[i] == B[j]) {
                    temp++;
                    backTrack(A, B, i + 1, j + 1, temp, max);
                    temp--;
                }
            }
        }
    }

}

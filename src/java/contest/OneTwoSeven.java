package java.contest;

import java.tools.TreeNode;

import java.util.Arrays;

public class OneTwoSeven {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int rev = 0;
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int a : A) min = Math.min(min, Math.abs(a));

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                if (rev < K) {
                    A[i] = -A[i];
                    rev++;
                } else break;
            } else break;
        }

        for (int a : A) res += a;
        if (rev < K && (K - rev) % 2 == 1) res -= 2 * A[rev];

        return res;
    }

    public int clumsy(int N) {
        int res = 1;

        for (int i = 0; i < N; i += 4) {

        }

        return res;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root;

        if (preorder.length > 3) {
            int mid = (preorder.length + 1) / 2;
            root = new TreeNode(preorder[0]);
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, mid + 1));
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, mid + 1, preorder.length));
        } else if (preorder.length == 3) {
            root = new TreeNode(preorder[0]);
            root.left = new TreeNode(preorder[1]);
            root.right = new TreeNode(preorder[2]);
        } else if (preorder.length == 2) {
            root = new TreeNode(preorder[0]);
            if (preorder[1] > preorder[0]) {
                root.right = new TreeNode(preorder[1]);
            } else
                root.left = new TreeNode(preorder[1]);
        } else if (preorder.length == 1) {
            root = new TreeNode(preorder[0]);
        } else {
            root = null;
        }

        return root;
    }
}

package java.contest;


import java.others.tools.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Contest135 {

    // 5051. Valid Boomerang
    public boolean isBoomerang(int[][] points) {
        if (isEqual(points[0], points[1]) || isEqual(points[0], points[2]) || isEqual(points[1], points[2]))
            return false;

        int[] ratio12 = new int[]{points[1][1] - points[0][1], points[1][0] - points[0][0]};
        int[] ratio13 = new int[]{points[2][1] - points[0][1], points[2][0] - points[0][0]};
        int[] ratio23 = new int[]{points[2][1] - points[1][1], points[2][0] - points[1][0]};

        if (ratio12[0] == 0 && ratio13[0] == 0 && ratio23[0] == 0) return false;
        if (ratio12[1] == 0 && ratio13[1] == 0 && ratio23[1] == 0) return false;

        return !(isEqual(ratio12, ratio23) || isEqual(ratio12,ratio13) || isEqual(ratio23, ratio13));
    }

    private boolean isEqual(int[] nums1, int[] nums2) {
        return nums1[0] == nums2[0] && nums1[1] == nums2[1];
    }


    // 5050. Binary Search Tree to Generate Sum Tree
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        List<Integer> res = new ArrayList<>();
        inOrderValues(root, res);

        for (int i = 1; i < res.size(); i++) {
            res.set(i, res.get(i) + res.get(i - 1));
        }

        LinkedList<Integer> resL = new LinkedList<>(res);

        return constructTree(root, resL);
    }

    private void inOrderValues(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrderValues(root.right, res);
            res.add(root.val);
            inOrderValues(root.left, res);
        }
    }

    private TreeNode constructTree(TreeNode origin, LinkedList<Integer> res) {
        if (origin == null) return null;

        TreeNode root = new TreeNode(0);

        if (origin.right != null) {
            root.right = constructTree(origin.right, res);
        }

        root.val = res.removeFirst();

        if (origin.left != null) {
            root.left = constructTree(origin.left, res);
        }

        return root;
    }

    // 3
    public int minScoreTriangulation(int[] A) {
        Arrays.sort(A);
        int ab = A[0] * A[1];
        int res = 0;

        for (int i = 2; i < A.length; i++) {
            res += ab * A[i];
        }

        return res;
    }
}

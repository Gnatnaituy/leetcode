package classify.binarysearchtree;

import others.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBST {
    private Integer prev = null;
    private int count = 1;
    private int max = 0;

    /**
     * 1ms 97.96%
     * 39.1MB 80.40%
     */
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);

        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;

        traverse(root.left, list);

        if (prev != null) {
            count = root.val == prev ? count + 1 : 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;

        traverse(root.right, list);
    }
}

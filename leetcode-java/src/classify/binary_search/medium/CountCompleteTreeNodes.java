package classify.binary_search.medium;

import tools.TreeNode;

public class CountCompleteTreeNodes {

    /**
     * 0ms      100.00%
     * 43.9MB   83.4%
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.right) + countNodes(root.left);
    }
    
    /**
     * 13ms     7.76%
     * 45.1MB   5.05%
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            level++;
            cur = cur.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean exists(TreeNode root, int level, int value) {
        int bits = 1 << (level - 1);
        System.out.print("value:" + value + " bits: " + bits + " > ");
        TreeNode node = root;
        while (node != null && bits > 0) {
            System.out.print(node.val + " ");
            if ((bits & value) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }

        System.out.println();
        return node != null;
    }
}

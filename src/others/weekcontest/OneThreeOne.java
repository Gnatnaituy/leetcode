package others.weekcontest;

import java.util.*;

public class OneThreeOne {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int x) { val = x; }
    }

    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int parCount = 0;
        int start = 0;
        int step = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                parCount++;
            } else {
                parCount--;
            }
            step++;
            if (parCount == 0) {
                res.append(S, start + 1, start + step - 1);
                start = start + step;
                step = 0;
            }
        }

        return res.toString();
    }

    public int sumRootToLeaf(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> values = new LinkedList<>();
        stack.add(root);
        values.add(root.val);

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                if (node.left != null || node.right != null) {
                    int value = values.remove(i);
                    if (node.left != null) {
                        stack.add(node.left);
                        values.add(value * 2 + node.left.val);
                    }
                    if (node.right != null) {
                        stack.add(node.right);
                        values.add(value * 2 + node.right.val);
                    }
                }
            }
        }

        int res = 0;
        for (int value : values) {
            res += value;
        }

        return res;
    }
}

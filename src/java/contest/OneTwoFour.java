package java.contest;

import java.others.tools.TreeNode;

import java.util.LinkedList;

public class OneTwoFour {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;

        LinkedList<TreeNode> stack = new LinkedList<>();
        int depth = 0;
        int depthX = 0;
        int depthY = 0;
        int fatherX = 0;
        int fatherY = 0;

        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();

            while (size > 0) {
                TreeNode node = stack.remove(0);

                if (node.left != null) {
                    stack.add(node.left);
                    if (node.left.val == x) {
                        depthX = depth;
                        fatherX = node.val;
                    }
                    if (node.left.val == y) {
                        depthY = depth;
                        fatherY = node.val;
                    }
                }

                if (node.right != null) {
                    stack.add(node.right);
                    if (node.right.val == x) {
                        depthX = depth;
                        fatherX = node.val;
                    }
                    if (node.right.val == y) {
                        depthY = depth;
                        fatherY = node.val;
                    }
                }

                size--;
            }

            depth++;
        }

        return (depthX == depthY) && (fatherX != fatherY);
    }

    public static void main(String[] args) {
        OneTwoFour oneTwoFour = new OneTwoFour();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(oneTwoFour.isCousins(root, 4, 5));
    }
}

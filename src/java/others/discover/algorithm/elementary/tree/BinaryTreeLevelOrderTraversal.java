package java.others.discover.algorithm.elementary.tree;


import java.others.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 2ms 68.09%
     * 22.6m 37.24%
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> levelNodes = new LinkedList<>();

        if (root == null) return res;

        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
            List<Integer> levelValues = new LinkedList<>();
            int size = levelNodes.size();

            while (size > 0) {
                TreeNode node = levelNodes.removeFirst();
                levelValues.add(node.val);
                if (node.left != null) levelNodes.add(node.left);
                if (node.right != null) levelNodes.add(node.right);
                size--;
            }

            res.add(levelValues);
        }

        return res;
    }


    /**
     * 0ms
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>>list= new ArrayList<>();
        addlevel(list, 0, root);
        return list;
    }


    private void addlevel(List<List<Integer>> list, int level, TreeNode node){
        if (node == null) return;

        if (list.size() - 1 < level)
            list.add(new ArrayList<>());
        list.get(level).add(node.val);

        addlevel(list, level + 1, node.left);
        addlevel(list, level + 1, node.right);
    }
}

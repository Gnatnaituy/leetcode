package others.easy.ktwenty;

import others.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872 Leaf-Similar Trees
 */

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        leafValues(root1, res1);
        leafValues(root2, res2);

        return res1.equals(res2);
    }

    private void leafValues(TreeNode root, List<Integer> res) {
        if (root == null) return;

        if (root.left == null && root.right == null) 
            res.add(root.val);
        else {
            if (root.left != null) leafValues(root.left, res);
            if (root.right != null) leafValues(root.right, res);
        }     
    }
}
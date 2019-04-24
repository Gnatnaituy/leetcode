package others.easy.gtwenty;

import others.tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501 Find Mode in Binary Search Tree
 *
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stackanddfs space incurred due to recursion does not count).
 */

public class FindModeInBST {

    private static int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        traversal(root, hashMap);

        int mode = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > mode)
                mode = entry.getValue();
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == mode)
                res.add(entry.getKey());
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);

        return result;
    }

    private static void traversal(TreeNode root, HashMap<Integer, Integer> hashMap) {
        if (root == null) return;

        if (hashMap.containsKey(root.val))
            hashMap.put(root.val, hashMap.get(root.val) + 1);
        else
            hashMap.put(root.val, 1);

        if (root.left != null)
            traversal(root.left, hashMap);
        if (root.right != null)
            traversal(root.right, hashMap);
    }
}

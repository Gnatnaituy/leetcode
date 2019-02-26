package others.easy.btwenty;


import tools.StringToTreeNode;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 112 Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSun {

    private static void pathSums(TreeNode root, ArrayList<Integer> result, String oneRoad) {

        oneRoad += root.val + "-";

        if (root.left != null)
            pathSums(root.left, result, oneRoad);

        if (root.right != null)
            pathSums(root.right, result, oneRoad);

        if (root.left == null && root.right == null) {
            Integer sum = 0;
            String[] resultInt = oneRoad.split("-");
            for (String one : resultInt)
                sum += Integer.parseInt(one);
            result.add(sum);
        }
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        String oneRoad = "";

        if (root == null)
            return false;

        pathSums(root, result, oneRoad);

        return result.contains(sum);
    }


    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        if (root == null) return list;

        iterator(root,list,"");
        return list;
    }

    private static void iterator(TreeNode root, List<String> list, String string) {
        string += root.val + " ";

        if (root.left == null && root.right == null)
            list.add(string.trim().replace(" ","->"));

        if (root.left != null)
            iterator(root.left,list,string);

        if (root.right != null)
            iterator(root.right,list,string);
    }


    public static void main(String[] args) {
        System.out.print(
                hasPathSum(
                StringToTreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]"),
                22));
        System.out.println();
        System.out.println(
                binaryTreePaths(
                        StringToTreeNode.stringToTreeNode(
                                "[5,4,8,11,null,13,4,7,2,null,null,null,1]")));
    }
}

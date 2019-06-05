package java.others.easy.gtwenty;

import java.others.tools.TreeNode;

/**
 * 543 Diameter of Binary Tree
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 * 
 * Example:
 * Given a binary tree 
 *        1
 *       / \
 *      2   3
 *     / \     
 *    4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTree {
    private static int dia = 0;

    private static int diameterOfBinaryTree(TreeNode root) {
        treeLength(root);
        return dia;
    }

    private static int treeLength(TreeNode root){
        if(root == null){
            return 0;
        }
        int l_len = treeLength(root.left);
        int r_len = treeLength(root.right);
        if(dia < l_len + r_len){
            dia = l_len + r_len;
        }
        return Math.max(l_len,r_len)+1;
    }

}
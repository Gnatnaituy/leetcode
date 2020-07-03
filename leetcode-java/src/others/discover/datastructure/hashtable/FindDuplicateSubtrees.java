package others.discover.datastructure.hashtable;


import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可
 * 两棵树重复是指它们具有相同的结构以及相同的结点值
 */
public class FindDuplicateSubtrees {

    /**
     * 29ms 93.55%
     * 把整棵字数转化为字符串作为HashMap的键
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        find(root,map,list);

        return list;
    }

    private String find(TreeNode root, Map<String,Integer> map, List<TreeNode> list){
        if(root == null) return "*";

        String str = root.val + "#" + find(root.left,map,list) + "#" + find(root.right,map,list);
        if (map.containsKey(str)) list.add(root);
        map.put(str, map.getOrDefault(str,0) + 1);

        return str;
    }
}

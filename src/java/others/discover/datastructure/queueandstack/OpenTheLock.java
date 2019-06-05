package java.others.discover.datastructure.queueandstack;


import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。
 * 每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 提示：
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        String start = "0000";
        queue1.offer(start);
        int step = 0;

        if(dead.contains(target)||dead.contains("0000")) return -1;
        while(!queue1.isEmpty()){
            String cur = queue1.poll();
            if (target.equals(cur)) {
                return step;
            }
            List<String> nexts = getNexts(cur);
            for (String s : nexts) {
                if(!dead.contains(s) && !visited.contains(s)) {
                    visited.add(s);
                    queue2.offer(s);
                }
            }
            if (queue1.isEmpty()) {
                queue1=queue2;
                queue2= new LinkedList<>();
                step++;
            }

        }

        return -1;
    }

    /**
     *获取邻接的所有节点
     */
    private List<String> getNexts(String cur){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            StringBuilder curSb= new StringBuilder(cur);
            curSb.setCharAt(i, cur.charAt(i) == '0' ? '9' : (char) (cur.charAt(i) - 1));
            list.add(curSb.toString());
            curSb.setCharAt(i, cur.charAt(i) == '9' ? '0' : (char) (cur.charAt(i) + 1));
            list.add(curSb.toString());

        }

        return list;
    }
}

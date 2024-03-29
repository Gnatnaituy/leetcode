package classify.hash;


import java.util.*;

/**
 * 380 常数时间插入, 删除和获取随机元素
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class InsertDeleteGetRandomInvariable {

}


/**
 * 蜜汁过不了(说好的随机返回呢...)
 */
class RandomizedSet {
    private HashSet<Integer> set;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)) return false;
        set.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < new Random().nextInt(set.size()); i++)
            iterator.next();

        return iterator.next();
    }
}


/**
 * 128ms 53.48%
 */
class RandomizedSet2 {
    private Map<Integer,Integer> hash = new HashMap<>();
    private List<Integer> arr = new ArrayList<>();
    public RandomizedSet2() {
    }
    public boolean insert(int val) {
        if(hash.containsKey(val))return false;
        hash.put(val,arr.size());
        arr.add(val);
        return true;
    }
    public boolean remove(int val) {
        if(!hash.containsKey(val)) return false;
        Integer integer = hash.get(val);
        {
            int dd = arr.get(arr.size()-1);
            arr.set(integer , arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            hash.put(dd,integer);
        }
        hash.remove(val);
        return true;
    }

    public int getRandom() {
        if(arr.size() == 0)return 0;
        else return arr.get(new Random().nextInt(arr.size()));
    }
}

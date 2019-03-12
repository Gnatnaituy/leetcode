package others.easy.itwenty;

import java.util.Arrays;

/**
 * 705 Design HashSet
 */

/**
 * 175ms
 */
public class DesignHashSet {
    int[] hashSet = new int[1000001];

    public DesignHashSet() {
        Arrays.fill(hashSet, -1);
    }

    public void add(int key) {
        hashSet[key] = key;
    }

    public void remove(int key) {
        hashSet[key] = -1;
    }

    public boolean contains(int key) {
        return hashSet[key] == key;
    }
}

/**
 * 82ms
 */
class MyHashSet {

    private boolean set [];

    public MyHashSet() {
        set =new boolean [1000000];
    }

    public void add(int key) {
        set[key]=true;
    }

    public void remove(int key) {
        set[key]=false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
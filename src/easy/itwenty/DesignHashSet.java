package easy.itwenty;

import java.util.Arrays;

/**
 * 705 Design HashSet
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
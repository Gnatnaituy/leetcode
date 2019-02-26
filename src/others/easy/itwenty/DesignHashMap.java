package others.easy.itwenty;

import java.util.Arrays;

/**
 * 706 Design HashMap
 */

public class DesignHashMap {
    int[] keys = new int[1000001];
    int[] vals = new int[1000001];

    public DesignHashMap() {
        Arrays.fill(keys, -1);
        Arrays.fill(vals, -1);
    }

    public void put(int key, int value) {
        keys[key] = key;
        vals[key] = value;
    }

    public int get(int key) {
        return vals[key];
    }

    public void remove(int key) {
        keys[key] = -1;
        vals[key] = -1;
    }
}
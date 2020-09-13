package contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/9/13 10:27
 * @Description Week206
 */
public class Week206 {

    public int numSpecial(int[][] mat) {
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> row = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int rowc = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowc++;
                }
            }
            row.put(i, rowc);
        }

        for (int i = 0; i < mat[0].length; i++) {
            int colc = 0;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 1) {
                    colc++;
                }
            }
            col.put(i, colc);
        }

        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; i < mat[i].length; j++) {
                if (mat[i][j] == 1 && col.get(j) == 1 && row.get(i) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Set<Integer> unhappies = new HashSet<>();

        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            int[] aFriends = preferences[a];
            int[] bFriends = preferences[b];


            for (int index = 0; index < aFriends.length; index++) {
                if (aFriends[index] == b && index > 0 && !unhappies.contains(a)) {
                    int res = isUnhappy(preferences, a, index);
                    if (res != -1) {
                        unhappies.add(a);
                        unhappies.add(aFriends[res]);
                    }
                }
            }
        }

        return unhappies.size();
    }

    Integer isUnhappy(int[][] preference, int a, int ab) {
        for (int i = 0; i < ab; i++) {
            int[] cFriends = preference[preference[a][i]];
            for (int j = 0; j < cFriends.length; j++) {
                if (cFriends[j] == a && j < ab) {
                    return i;
                }
            }
        }
        return -1;
    }
}

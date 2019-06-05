package java.others.easy.mtwenty;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    
    public int[][] kClosest(int[][] points, int K) {
        int[] distances = new int[points.length];
        
        Arrays.sort(points, (o1, o2) -> {
            int x = o1[0] * o1[0] + o1[1] * o1[1];
            int y = o2[0] * o2[0] + o2[1] * o2[1];
            if (x > y)
                return -1;
            else
                return 1;
        });
        
        int[][] res = new int[K][];
        System.arraycopy(points, 0, res, 0, K);
        
        return res;
    }
}

package easy.ltwenty;

import java.util.BitSet;

/**
 * 888 Fair Candy Swap
 */

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int B[]) {
//        int sumA = 0, sumB = 0;

//         for (int a : A)
//             sumA += a;
//         for (int b : B)
//             sumB += b;

//         for (int a : A) {
//             for (int b : B) {
//                 if ((sumA - a + b) == (sumB - b + a))
//                     return new int[]{a, b};
//             }
//         }

//         return new int[]{1, 1};
    
        int sumA = 0, sumB = 0;
        BitSet bitSet = new BitSet();
    
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            bitSet.set(b, true);
            sumB += b;
        }
        int sub = (sumB - sumA) / 2;
        for (int a : A) {
            if (a + sub <= 0)
                continue;
            if (bitSet.get(a + sub)) {
                return new int[]{a, a + sub};
            }
        }
    
        return null;
    }
}

package easy.ftwenty;

/**
 * 461 Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance {

    private static int hammingDistance(int x, int y) {

        // 12ms surpass 37.9% users.....
//        int z = x ^ y, result = 0;
//        String s =  Integer.toBinaryString(z);
//        for (int i = 0; i < s.length(); i++)
//            if (s.charAt(i) == '1') result++;
//
//        return result;

        // Fastest......
        int count = 0;
        while(x > 0 || y > 0){
            if((x & 1 ) != (y & 1)){
                count ++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        return count;
    }
}

package others.easy.ltwenty;

/**
 * 922 Sort Array by Parity II
 */

public class SortArrayByParityII {

    private int[] sortArrayByParityII(int[] A) {
        
        // 10ms , surpass 70.82 users...
//        int even = 0, odd = 1;
//
//        while (even < A.length && odd < A.length) {
//            while (even < A.length && A[even] % 2 == 0)
//                even += 2;
//            while (odd < A.length && A[odd] % 2 == 1)
//                odd += 2;
//            if (even < A.length && odd < A.length) {
//                int temp = A[even];
//                A[even] = A[odd];
//                A[odd] = temp;
//            }
//        }
//
//        return A;
        
        int odd = 1;
        for (int even = 0; even < A.length - 1; even += 2) {
            if ((A[even] & 1) != 0) {
                while ((A[odd] & 1) != 0) {
                    odd += 2;
                }
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }
        return A;
    }
    
    public static void main(String[] args) {
        SortArrayByParityII demo = new SortArrayByParityII();
        int[] a = {4, 1, 7, 8, 6, 9, 6, 9};
        int[] c = demo.sortArrayByParityII(a);
        for (int b : c)
            System.out.print(b);
    }
}

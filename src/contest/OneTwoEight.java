package contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OneTwoEight {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        System.out.println((int) Math.pow(2, 3));
        System.out.println(bitwiseComplement(7));
        System.out.println(bitwiseComplement(10));
    }

    private static int bitwiseComplement(int N) {
        String binaryN = Integer.toBinaryString(N);
        int res = 0;

        for (int i = binaryN.length() - 1; i >= 0; i--) {
            if (binaryN.charAt(i) == '0') {
                res += (int) Math.pow(2, binaryN.length() - i - 1);
            }
        }

        return res;
    }

    private static int numPairsDivisibleBy60(int[] time) {
        int res = 0;

        if (time.length < 2) return res;

        for (int i = 0; i < time.length - 1; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0)
                    res++;
            }
        }

        return res;
    }

    public int missingElement(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                k -= nums[i] - nums[i - 1] - 1;
            }
            if (k <= 0) {
                return nums[i] - nums[i + k - 1];
            }
        }

        return nums[nums.length - 1] + k;
    }

    public String smallestEquivalentString(String A, String B, String S) {
        List<HashSet<Character>> set = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            boolean contains = false;
            for (HashSet<Character> hashSet : set) {
                if (hashSet.contains(A.charAt(i)) || hashSet.contains(B.charAt(i))) {
                    contains = true;
                    set.remove(hashSet);
                    hashSet.add(A.charAt(i));
                    hashSet.add(B.charAt(i));
                    set.add(hashSet);
                }
            }
            if (!contains) {
                HashSet<Character> newSet = new HashSet<>();
                newSet.add(A.charAt(i));
                newSet.add(B.charAt(i));
                set.add(newSet);
            }
        }

        for (char s : S.toCharArray()) {
            boolean contains = false;
            for (HashSet<Character> set1 : set) {
                if (set1.contains(s)) {
                    contains = true;
                    res.append(minChar(set1));
                    break;
                }
            }
            if (!contains) {
                res.append(s);
            }
        }

        return res.toString();
    }

    private char minChar(HashSet<Character> set) {
        char c = 'z';

        for (char c1 : set) {
            if (c1 < c)
                c = c1;
        }

        return c;
    }
}

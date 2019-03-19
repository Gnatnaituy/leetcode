package others;

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
}

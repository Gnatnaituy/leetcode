package others.easy.atwenty;

public class SqrtOfX {

    private static int mySqrt(int x) {

        return (int) Math.sqrt(x);
    }

    private static int mySqrt2(int x) {
        if (x == 0) return 0;
        long sqrt = x;

        while (sqrt * sqrt > x) {
            sqrt = (sqrt + x / sqrt) / 2;
        }

        return (int) sqrt;
    }
}

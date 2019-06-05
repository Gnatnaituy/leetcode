package java.classify.greedy;

public class CanPlaceFlowers {

    /**
     * 1ms 100.00%
     * 38.7MB 94.12%
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1
                    || (i < flowerbed.length - 1 && flowerbed[i + 1] == 1)
                    || (i > 0 && flowerbed[i - 1] == 1)) {
                continue;
            }
            flowerbed[i] = 1;
            n--;
        }

        return n <= 0;
    }
}

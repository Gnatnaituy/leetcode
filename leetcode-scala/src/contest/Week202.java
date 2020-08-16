package contest;

import java.util.Arrays;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/8/16 10:29
 * @Description Week202
 */
public class Week202 {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) return true;
        }
        return false;
    }

    public int minOperations(int n) {
        int res = 0;
        if (n % 2 == 1) {
            for (int i = 1; i < n; i += 2) res += i;
        } else {
            for (int i = 2; i < n; i += 2) res += i;
        }
        return res;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int step = position.length / m;
        int tail = position.length % m;
        return 0;
    }

    public static int minDays(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 6; i < n + 1; i++) {
            if (i % 2 == 0) {
                if (i % 3 == 0) {
                    arr[i] = Math.min(Math.min(arr[i - 1], arr[i / 2]), arr[i / 3]);
                } else {
                    arr[i] = Math.min(arr[i - 1], arr[i / 2]);
                }
            } else {
                if (i % 3 == 0) {
                    arr[i] = Math.min(arr[i - 1], arr[i / 3]);
                } else {
                    arr[i] = arr[i - 1];
                }
            }
            arr[i]++;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.print(minDays(61455274) + "");
    }
}

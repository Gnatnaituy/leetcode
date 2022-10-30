package contest;

import java.util.Arrays;

public class DoubleWeeklyContest87 {
    
    /**
     * 通过
     */
    // public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
    //     int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //     int aam = Integer.parseInt(arriveAlice, 0, 2, 10);
    //     int aad = Integer.parseInt(arriveAlice, 3, 5, 10);
    //     int lam = Integer.parseInt(leaveAlice, 0, 2, 10);
    //     int lad = Integer.parseInt(leaveAlice, 3, 5, 10);
    //     int abm = Integer.parseInt(arriveBob, 0, 2, 10);
    //     int abd = Integer.parseInt(arriveBob, 3, 5, 10);
    //     int lbm = Integer.parseInt(leaveBob, 0, 2, 10);
    //     int lbd = Integer.parseInt(leaveBob, 3, 5, 10);
        
    //     int sm, sd, lm, ld;
    //     if (aam > abm) {
    //         sm = aam;
    //         sd = aad;
    //     } else {
    //         sm = abm;
    //         sd = aam == abm ? Math.max(aad, abd) : abd;
    //     }
    //     if (lam > lbm) {
    //         lm = lbm;
    //         ld = lbd;
    //     } else {
    //         lm = lam;
    //         ld = lam == lbm ? Math.min(lad, lbd) : lad;
    //     }

    //     if (sm > lm) {
    //         return 0;
    //     } else if (sm == lm) {
    //         return Math.max(0, ld - sd + 1);
    //     } else {
    //         int res = 0;
    //         res += monthDays[sm - 1] - sd + 1;
    //         res += ld;
    //         for (int i = sm + 1; i < lm; i++) {
    //             res += monthDays[i - 1];
    //         }

    //         return res;
    //     }
    // }

    /**
     * 通过
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int res = 0;
        for (int i = players.length - 1, j = trainers.length - 1; ; ) {
            if (i < 0 || j < 0) {
                return res;
            }
            if (players[i] <= trainers[j]) {
                res++;
                i--;
                j--;
            } else {
                i--;
            }
        }
    }

    /**
     * 超时
     */
    public int[] smallestSubarrays(int[] nums) {
        int res[] = new int[nums.length];
        res[nums.length - 1] = 1;
        int max = nums[nums.length - 1], curMax;
        for (int i = nums.length - 2; i >= 0; i--) {
            curMax = nums[i] | max;
            if (nums[i] == curMax) {
                res[i] = 1;
            } else {
                int len = 1, temp = nums[i], start = i + 1;
                while (temp < curMax && start < nums.length) {
                    temp |= nums[start++];
                    len++;
                }
                res[i] = len;
            }
            max = curMax;
        }

        return res;
    }

    /**
     * 通过
     */
    public int[] smallestSubArrays2(int[] nums) {
        int[] bit = new int[32];
        int[] res = new int[nums.length];
        int tail, index;
        for (int i = nums.length -1; i >= 0; i--) {
            tail = i; index = 31;
            while (nums[i] != 0) {
                if (nums[i] % 2 == 1) {
                    bit[index] = i;
                } else {
                    if (bit[index] > 0) {
                        tail = Math.max(tail, bit[index]);
                    }
                }
                nums[i] /= 2;
                index--;
            }
            while (index > 0) {
                if (bit[index] > 0) {
                    tail = Math.max(tail, bit[index]);
                }
                index--;
            }
            res[i] = tail - i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        DoubleWeeklyContest87 a = new DoubleWeeklyContest87();
        a.smallestSubarrays(new int[]{1,0,2,1,3});
    }
}

package others.easy.ktwenty;

/**
 * 849 Maximize Distance to Closest Person
 */

public class MaxDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int maxEmpty = 0, head = 0, tail = 0, start = 0, end = 1;
    
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                head = i;
                break;
            }
        }
    
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                tail = seats.length - i - 1;
                break;
            }
        }
    
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                start = i;
                for (int j = i; j < seats.length; j++) {
                    if (seats[j] == 1) {
                        end = j;
                        maxEmpty = maxEmpty > end - start ? maxEmpty : end - start;
                        break;
                    }
                }
            }
        }
    
        return Math.max(Math.max(head, tail), (maxEmpty + 1) / 2);
    }
}

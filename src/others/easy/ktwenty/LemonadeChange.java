package others.easy.ktwenty;

/**
 * 860 Lemonade Change
 */

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int num1 =0;
        int num2 =0;
        
        for (int bill : bills) {
            if (bill == 5) {
                num1++;
            } else if (bill == 10 && num1 > 0) {
                num1--;
                num2++;
            } else if (bill == 20 && num2 > 0 && num1 > 0) {
                num2--;
                num1--;
            } else if (bill == 20 && num1 >= 3) {
                num1 = num1 - 3;
            } else {
                return false;
            }
        }
        
        return true;
    }
}

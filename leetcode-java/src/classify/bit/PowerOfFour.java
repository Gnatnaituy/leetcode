package classify.bit;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }

    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
}

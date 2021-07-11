package classify.design;

/**
 * @author yutiantang
 * @create 2021/7/11 10:49
 */
public class DesignParkingSystem {

    private int big;
    private int medium;
    private int small;

    /**
     * 8ms      99.70%
     * 39.2MB   48.45%
     * @param big
     * @param medium
     * @param small
     */
    public DesignParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big == 0) return false;
                else big--; return true;
            case 2:
                if (medium == 0) return false;
                else medium--; return true;
            case 3:
                if (small == 0) return false;
                else small--; return true;
            default: return false;
        }
    }
}

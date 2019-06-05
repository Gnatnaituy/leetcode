package java.others.discover.datastructure.queueandstack;

public class SleepSort implements Runnable {
    private int t;

    private SleepSort(int t) {
        this.t = t;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(t);
            System.out.print(t + " ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 123, 123, 233, 45, 565, 12};

        for (int num : nums) {
            Thread thread = new Thread(new SleepSort(num));
            thread.start();
        }
    }
}

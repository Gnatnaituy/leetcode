package others;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input a numbers: ");
        int num = scanner.nextInt();
        int para1 = Integer.valueOf(args[0]);
        int para2 = Integer.valueOf(args[1]);
        scanner.close();

        PersonException demo = new PersonException(para1, para2);

        try {
            demo.handleNumber(num);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            demo.handleParameter(para1, para2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            demo.handleCustom(num);
        } catch (DemoException.CustomException e) {
            e.printStackTrace();
        }
    }
}

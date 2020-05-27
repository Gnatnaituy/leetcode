package java.others;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input a numbers: ");
        int num = scanner.nextInt();
        int param1 = Integer.parseInt(args[0]);
        int param2 = Integer.parseInt(args[1]);
        scanner.close();

        PersonException demo = new PersonException(param1, param2);

        try {
            demo.handleNumber(num);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            demo.handleParameter(param1, param2);
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

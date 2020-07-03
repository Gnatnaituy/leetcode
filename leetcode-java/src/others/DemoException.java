package others;

public class DemoException {

    class CustomException extends RuntimeException {

        public CustomException(String msg) {
            System.out.println("This is my custom exception");
            System.out.println(msg);
        }
    }

    public boolean handleNumber(int num) throws Exception {
        return true;
    }

    public boolean handleParameter(int para1, int para2) throws Exception {
        return true;
    }

    public boolean handleCustom(int num) throws CustomException {
        return true;
    }
}

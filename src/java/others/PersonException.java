package java.others;

public class PersonException extends DemoException {
    private int para1;
    private int para2;

    public PersonException() {
        para1 = 0;
        para2 = 0;
    }

    public PersonException(int para1, int para2) {
        this.para1 = para1;
        this.para2 = para2;
    }

    @Override
    public boolean handleNumber(int num) throws Exception {
        if (num != 2333) {
            throw new Exception("The number should equal to 2333");
        }

        return true;
    }

    @Override
    public boolean handleParameter(int para1, int para2) throws Exception {
        if (para1 != 1 || para2 != 2) {
            throw new Exception("The parameter is invalid");
        }

        return true;
    }

    @Override
    public boolean handleCustom(int num) throws CustomException {
        if (num != 2333) {
            throw new CustomException("The num should equal to 2333");
        }

        return true;
    }
}

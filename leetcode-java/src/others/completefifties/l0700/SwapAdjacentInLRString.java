package others.completefifties.l0700;

public class SwapAdjacentInLRString {

    public boolean canTransform(String start, String end) {
        int l = start.length();
        int i = 0, j = 0;

        while (i < l && j < l) {
            while (start.charAt(i) == 'X' && i < l - 1) ++i;
            while (end.charAt(j) == 'X' && j < l - 1) ++j;

            if (start.charAt(i) != end.charAt(j))
                return false;
            else if (start.charAt(i) == 'L' && i < j)
                return false;
            else if (start.charAt(i) == 'R' && i > j)
                return false;

            i++;
            j++;
        }

        return true;
    }
}

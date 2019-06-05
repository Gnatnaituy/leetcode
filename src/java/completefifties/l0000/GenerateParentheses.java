package java.completefifties.l0000;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 */

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
    
        return res;
    }
    
    private void generate(List<String> res, String ans, int count1, int count2, int n) {
        
        // count1 counts "(" and count2 counts ")"
        if(count1 > n || count2 > n)
            return;
        if(count1 == n && count2 == n)
            res.add(ans);
        if(count1 >= count2){
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans + ")", count1, count2 + 1, n);
        }
    }
}

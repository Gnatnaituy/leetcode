package easy.sixtwenty;

import java.util.Arrays;

/**
 * 455 Assign Cookies
 *
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size sj. If sj >= gi,
 * we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 *
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 *
 * Example 1:
 * Input: [1,2,3], [1,1]
 *
 * Output: 1
 *
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1,
 * you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 *
 * Example 2:
 * Input: [1,2], [1,2,3]
 *
 * Output: 2
 *
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */

public class AssignCookies {

    private static int findContentChildren(int[] g, int[] s) {

        // 107ms surpass 7.83% users only......
//        if (s.length == 0 || g.length == 0)
//            return 0;
//        int step = 0;
//        int result = g.length;
//        Arrays.sort(g);
//        Arrays.sort(s);
//        while (step < g.length) {
//            if (g[step] > s[s.length - 1]) {
//                result -= g.length - step;
//                return result;
//            } else {
//                for (int i = 0; i < s.length; i++) {
//                    if (g[step] <= s[i]) {
//                        step++;
//                        s[i] = 0;
//                        break;
//                    }
//                }
//            }
//        }
//        return result;

        // fastest solution......
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
